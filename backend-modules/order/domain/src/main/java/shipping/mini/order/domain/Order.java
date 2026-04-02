package shipping.mini.order.domain;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import shipping.mini.kernal.dto.entity.BaseEntity;

@Entity
@Table(name = "orders", uniqueConstraints = @UniqueConstraint(name = "uc_order_number", columnNames = "external_order_number"))
public class Order extends BaseEntity {
	
	@Column(nullable = false, name = "external_order_number")
	private String externalOrderNumber;
	
	private Long shipmentId;

	@OneToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "delivery_address_id", foreignKey = @ForeignKey(name = "fk_order_address"))
	private Address deliveryAddress;

	@OneToMany(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "order_id")
	private List<ItemLine> itemlines;

	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private OrderStatus orderStatus = OrderStatus.CREATED;

	public Order() {
		super();
	}
	
	public Order(String externalOrderNumber, Address deliveryAddress, List<ItemLine> itemlines) {
		this.externalOrderNumber = externalOrderNumber;
		this.deliveryAddress = deliveryAddress;
		this.itemlines = itemlines;
	}
	
	public Long getShipmentId() {
		return shipmentId;
	}

	public void setShipmentId(Long shipmentId) {
		this.shipmentId = shipmentId;
	}

	public String getExternalOrderNumber() {
		return externalOrderNumber;
	}

	public void setExternalOrderNumber(String externalOrderNumber) {
		this.externalOrderNumber = externalOrderNumber;
	}

	public Address getDeliveryAddress() {
		return deliveryAddress;
	}

	public void setDeliveryAddress(Address deliveryAddress) {
		this.deliveryAddress = deliveryAddress;
	}

	public List<ItemLine> getItemlines() {
		return itemlines;
	}

	public void setItemlines(List<ItemLine> itemlines) {
		this.itemlines = itemlines;
	}

	public OrderStatus getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(OrderStatus orderStatus) {
		this.orderStatus = orderStatus;
	}
}
