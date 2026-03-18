package shipping.mini.dto;

import shipping.mini.domain.ShipmentStatus;

public record ShipmentSearchCriteria(
	String carrier, 
	ShipmentStatus status) {
}
