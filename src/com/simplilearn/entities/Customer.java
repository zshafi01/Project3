package com.simplilearn.entities;

public class Customer {
	private String id;
	private String custName;
	private String email;
	private String street;
	private String city;
	private String zipcode;
	private String country;
	private String userId;
	private String approved;

	public Customer() {
	}

	public Customer(String id, String name, String email, String street, String city, String zipcode, String country,
			String userId, String approved) {
		super();
		this.id = id;
		this.custName = name;
		this.email = email;
		this.street = street;
		this.city = city;
		this.zipcode = zipcode;
		this.country = country;
		this.userId = userId;
		this.approved = approved;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCustName() {
		return custName;
	}

	public void setCustName(String name) {
		this.custName = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getApproved() {
		return approved;
	}

	public void setApproved(String approved) {
		this.approved = approved;
	}

}