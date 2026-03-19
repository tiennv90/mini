package shipping.mini.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import shipping.mini.exception.ResourceStateConflictException;
import shipping.mini.kernal.BaseEntity;

@Entity
@Table(name = "parcels", uniqueConstraints = @UniqueConstraint(name = "uc_tracking_code", columnNames = "tracking_code"))
public class Parcel extends BaseEntity {

	@Column(name = "tracking_code", nullable = true)
	private String trackingCode;
	
	@Column(nullable = false)
	private String carrier;

	@ManyToOne
	private Shipment shipment;

	public Parcel() {
		super();
	}
	
	public String getTrackingCode() {
		return trackingCode;
	}

	public void setTrackingCode(String trackingCode) {
		this.trackingCode = trackingCode;
	}

	public Shipment getShipment() {
		return shipment;
	}

	public void setShipment(Shipment shipment) {
		this.shipment = shipment;
	}
	
	public String getCarrier() {
		return carrier;
	}

	public void setCarrier(String carrier) {
		this.carrier = carrier;
	}	

	public void assignTracking(String trackingCode) throws ResourceStateConflictException {
		if (this.trackingCode != null) {
			throw new ResourceStateConflictException("Tracking code already assigned");
		}
		this.trackingCode = trackingCode;
	}

	public boolean hasTracking() {
		return trackingCode != null;
	}
}
