package com.mini.order.domain;

import java.util.List;

public class OrderDomain {
	
	private Long id;
	private String externalOrderNumber;
	private Long shipmentId;
	private AddressDomain deliveryAddress;
	private List<ItemLineDomain> itemlines;
	private OrderStatusDomain orderStatus;
	
	public OrderStatusDomain getOrderStatus() {
		return orderStatus;
	}
	public void setOrderStatus(OrderStatusDomain orderStatus) {
		this.orderStatus = orderStatus;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getExternalOrderNumber() {
		return externalOrderNumber;
	}
	public void setExternalOrderNumber(String externalOrderNumber) {
		this.externalOrderNumber = externalOrderNumber;
	}
	public Long getShipmentId() {
		return shipmentId;
	}
	public void setShipmentId(Long shipmentId) {
		this.shipmentId = shipmentId;
	}
	public AddressDomain getDeliveryAddress() {
		return deliveryAddress;
	}
	public void setDeliveryAddress(AddressDomain deliveryAddress) {
		this.deliveryAddress = deliveryAddress;
	}
	public List<ItemLineDomain> getItemlines() {
		return itemlines;
	}
	public void setItemlines(List<ItemLineDomain> itemlines) {
		this.itemlines = itemlines;
	}
}
