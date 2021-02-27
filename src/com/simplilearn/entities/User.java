package com.simplilearn.entities;

import java.util.UUID;


public class User {

	private String id;
	private String name;
	private String address;
	private String email;
	private String password;
	private String type;

	public User() {
		super();
	}

	public User(String name, String address, String email, String password, String type) {
		super();
		this.name = name;
		this.address = address;
		this.email = email;
		this.password = password;
		this.type = type;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return String.format("User [id=%s, name=%s, address=%s, email=%s, password=%s, type=%s]", id, name, address,
				email, password, type);
	}
	
	
	

}
