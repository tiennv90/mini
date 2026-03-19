package shipping.mini.domain;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import shipping.mini.kernal.BaseEntity;

@Entity
@Table(name = "shipments", uniqueConstraints = @UniqueConstraint(name = "uc_order_id", columnNames = "order_id"))
public class Shipment extends BaseEntity {

	@OneToMany(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "shipment_id", foreignKey = @ForeignKey(name = "fk_shipment_parcel"))
	private List<Parcel> parcels = new ArrayList<Parcel>();

	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private ShipmentStatus shipmentStatus = ShipmentStatus.CREATED;

	@Column
	@DateTimeFormat(iso = ISO.DATE_TIME)
	private ZonedDateTime shippedAt;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "order_id", foreignKey = @ForeignKey(name = "fk_order_shipment"))
	private Order order;

	public Shipment() {
		super();
	}

	public Shipment(Long id) {
		setId(id);
	}

	public ZonedDateTime getShippedAt() {
		return shippedAt;
	}

	public void setShippedAt(ZonedDateTime shippedAt) {
		this.shippedAt = shippedAt;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public List<Parcel> getParcels() {
		return parcels;
	}

	public void setParcels(List<Parcel> parcels) {
		this.parcels = parcels;
	}

	public ShipmentStatus getShipmentStatus() {
		return shipmentStatus;
	}

	public void setShipmentStatus(ShipmentStatus shipmentStatus) {
		this.shipmentStatus = shipmentStatus;
	}
	
}
