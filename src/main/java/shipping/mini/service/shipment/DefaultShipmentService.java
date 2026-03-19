package shipping.mini.service.shipment;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import shipping.mini.component.ParcelDataLoader;
import shipping.mini.component.ShipmentSpecificationBuilderComponent;
import shipping.mini.domain.Parcel;
import shipping.mini.domain.Shipment;
import shipping.mini.domain.ShipmentStatus;
import shipping.mini.dto.ShipmentDTO;
import shipping.mini.dto.ShipmentSearchCriteria;
import shipping.mini.dto.request.ChangeShipmentRequest;
import shipping.mini.exception.EntityNotfoundException;
import shipping.mini.exception.ResourceStateConflictException;
import shipping.mini.mapper.ShipmentMapper;
import shipping.mini.repsitory.ShipmentRepository;

@Service
public class DefaultShipmentService implements ShipmentService {

	private final ShipmentRepository shipmentRepository;
	private final ParcelDataLoader parcelDataLoader;
	private final ShipmentSpecificationBuilderComponent specBuilderComponent;
	private final Map<ShipmentStatus, ShipmentCommand> commands;

	public DefaultShipmentService(ShipmentRepository shipmentRepository,
			ShipmentSpecificationBuilderComponent specBuilderComponent, ParcelDataLoader parcelDataLoader,
			List<ShipmentCommand> commandList) {
		this.shipmentRepository = shipmentRepository;
		this.specBuilderComponent = specBuilderComponent;
		this.parcelDataLoader = parcelDataLoader;
		this.commands = commandList.stream()
				.collect(Collectors.toMap(ShipmentCommand::getTargetStatus, c -> c));
	}

	@Override
	public Shipment getShipMenDetails(Long id) throws EntityNotfoundException {
		return shipmentRepository.findShipmentDetailsById(id)
				.orElseThrow(() -> new EntityNotfoundException("Shipment not found for id " + id));
	}

	@Override
	public Page<ShipmentDTO> getShipments(ShipmentSearchCriteria searchCriteria, Pageable pageable) {
		Specification<Shipment> spec = specBuilderComponent.build(searchCriteria);
		Page<Shipment> shipmentsPage = shipmentRepository.findAll(spec, pageable);
		List<Long> shipmentIds = shipmentsPage.stream().map(Shipment::getId).toList();
		Map<Long, List<Parcel>> parcelMap = parcelDataLoader.load(shipmentIds);
		List<ShipmentDTO> shipmentDTOs = shipmentsPage.stream()
				.map(s -> ShipmentMapper.mapToShipmentDTO(s, parcelMap.get(s.getId()))).toList();
		return new PageImpl<>(shipmentDTOs, pageable, shipmentsPage.getTotalElements());
	}
	
	@Override
	public ShipmentDTO updateStatus(Long id, ChangeShipmentRequest req) throws EntityNotfoundException, ResourceStateConflictException {
		Shipment shipment = getShipment(id);
		ShipmentCommand command = commands.get(req.newShipmentStatus());
		command.execute(shipment);
		return ShipmentMapper.mapToShipmentDTO(shipmentRepository.save(shipment));
	}

	private Shipment getShipment(Long id) throws EntityNotfoundException {
		return shipmentRepository.findById(id)
				.orElseThrow(() -> new EntityNotfoundException("Shipment not found for Id: " + id));
	}

}
