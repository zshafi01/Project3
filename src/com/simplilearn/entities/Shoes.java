package com.simplilearn.entities;

public class Shoes {
	private String id;
	private String brand_Name;
	private String color;
	private int size;
	private String image;
	private double price;
	
	
	public Shoes() {
		super();
	}


	public Shoes(String brand_Name, String color, int size, String image, double price) {
		super();
		this.brand_Name = brand_Name;
		this.color = color;
		this.size = size;
		this.image = image;
		this.price = price;
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getBrand_Name() {
		return brand_Name;
	}


	public void setBrand_Name(String brand_Name) {
		this.brand_Name = brand_Name;
	}


	public String getColor() {
		return color;
	}


	public void setColor(String color) {
		this.color = color;
	}


	public int getSize() {
		return size;
	}


	public void setSize(int size) {
		this.size = size;
	}


	public String getImage() {
		return image;
	}


	public void setImage(String image) {
		this.image = image;
	}


	public double getPrice() {
		return price;
	}


	public void setPrice(double price) {
		this.price = price;
	}


	@Override
	public String toString() {
		return String.format("Shoes [id=%s, brand_Name=%s, color=%s, size=%s, image=%s, price=%s]", id, brand_Name,
				color, size, image, price);
	}
	
	
	

}
