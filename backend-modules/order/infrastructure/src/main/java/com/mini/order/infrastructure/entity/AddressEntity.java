package com.mini.order.infrastructure.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import shipping.mini.kernal.dto.entity.BaseEntity;

@Entity
@Table(name = "address")
public class AddressEntity extends BaseEntity {

	@Column(nullable = false)
	private String street;
	
	@Column(nullable = false)
	private String houseNumber;	
	
	@Column(nullable = false)
	private String postalCode;
	
	@Column(nullable = false)
	private String city;
	
	@Column(nullable = false)
	private String country;

	public AddressEntity() {
		super();
	}
	
	public AddressEntity(String street, String houseNumber, String postalCode, String city, String country) {
		this.street = street;
		this.houseNumber = houseNumber;
		this.postalCode = postalCode;
		this.city = city;
		this.country = country;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getHouseNumber() {
		return houseNumber;
	}

	public void setHouseNumber(String houseNumber) {
		this.houseNumber = houseNumber;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}
}
