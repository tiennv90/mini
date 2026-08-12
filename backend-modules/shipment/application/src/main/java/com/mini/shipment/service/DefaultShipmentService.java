package com.mini.shipment.service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.mini.shipment.domain.command.ShipmentCommand;
import com.mini.shipment.domain.exception.ShipmentNotFoundException;
import com.mini.shipment.domain.exception.ShipmentStatusConflictException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.mini.shipment.component.ParcelDataLoader;
import com.mini.shipment.domain.ShipmentDomain;
import com.mini.shipment.domain.ShipmentStatus;
import com.mini.shipment.domain.repository.ShipmentDomainRepository;
import com.mini.shipment.dto.ParcelDTO;
import com.mini.shipment.dto.ShipmentDTO;
import com.mini.shipment.dto.request.ChangeShipmentRequest;
import com.mini.shipment.dto.request.ShipmentSearchCriteria;
import com.mini.shipment.mapper.ShipmentDomainMapper;
import com.mini.shipment.searchquery.ShipmentSearchQueryService;

@Service
public class DefaultShipmentService implements ShipmentService {

	private final ShipmentDomainRepository shipmentRepository;
	private final ParcelDataLoader parcelDataLoader;
	private final ShipmentSearchQueryService shipmentSearchQueryService;
	private final Map<ShipmentStatus, ShipmentCommand> commands;
	private final ShipmentDomainMapper mapper;
	private final ShipmentNotificationService shipmentNotificationService;

	public DefaultShipmentService(ShipmentDomainRepository shipmentRepository,
			ParcelDataLoader parcelDataLoader,
			List<ShipmentCommand> commandList, ShipmentDomainMapper mapper,
			ShipmentSearchQueryService shipmentSearchQueryService,
		  	ShipmentNotificationService shipmentNotificationService) {
		this.shipmentRepository = shipmentRepository;
		this.parcelDataLoader = parcelDataLoader;
		this.commands = commandList.stream()
				.collect(Collectors.toMap(ShipmentCommand::getTargetStatus, c -> c));
		this.mapper = mapper;
		this.shipmentSearchQueryService = shipmentSearchQueryService;
		this.shipmentNotificationService = shipmentNotificationService;
	}

	@Override
	public ShipmentDTO getShipMenDetails(Long id) throws ShipmentNotFoundException {
		ShipmentDomain shipment = shipmentRepository.findShipmentDetailsById(id)
				.orElseThrow(() -> new ShipmentNotFoundException("Shipment not found for id " + id));
		return mapper.toDTO(shipment);
	}

	@Override
	public Page<ShipmentDTO> getShipments(ShipmentSearchCriteria searchCriteria, Pageable pageable) {
		Page<ShipmentDomain> shipmentsPage = shipmentSearchQueryService.search(searchCriteria, pageable);
		List<Long> shipmentIds = shipmentsPage.stream().map(ShipmentDomain::getId).toList();
		Map<Long, List<ParcelDTO>> parcelMap = parcelDataLoader.load(shipmentIds);
		List<ShipmentDTO> shipmentDTOs = shipmentsPage.stream()
				.map(s -> mapper.toDTO(s, parcelMap.get(s.getId()))).toList();
		return new PageImpl<>(shipmentDTOs, pageable, shipmentsPage.getTotalElements());
	}
	
	@Override
	public ShipmentDTO updateStatus(Long id, ChangeShipmentRequest req) throws ShipmentNotFoundException,
			ShipmentStatusConflictException {
		ShipmentDomain shipment = getShipment(id);
		ShipmentCommand command = commands.get(req.newShipmentStatus());
		command.execute(shipment);
		shipment = shipmentRepository.save(shipment);
		shipmentNotificationService.sendNotification(mapper.toStatusChangeCommand(shipment));
		return mapper.toDTO(shipment);
	}

	private ShipmentDomain getShipment(Long id) throws ShipmentNotFoundException {
		return shipmentRepository.findById(id)
				.orElseThrow(() -> new ShipmentNotFoundException("Shipment not found for Id: " + id));
	}

	@Override
	public ShipmentDTO getShipmentByOrder(Long orderId) throws ShipmentNotFoundException {
		ShipmentDomain shipment = shipmentRepository.findByOrderId(orderId)
				.orElseThrow(() -> new ShipmentNotFoundException("No Shipment not found for Order id " + orderId));
		return mapper.toDTO(shipment);
	}

}
