package com.simplilearn.entities;

public class Shoes {
	private String id;
	private String brandName;
	private String color;
	private int size;
	private String image;
	private double price;

	public Shoes() {
		super();
	}

	public Shoes(String brandName, String color, int size, String image, double price) {
		super();
		this.brandName = brandName;
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

	public String getBrandName() {
		return brandName;
	}

	public void setBrandName(String brandName) {
		this.brandName = brandName;
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
		return String.format("Shoes [id=%s, brand_Name=%s, color=%s, size=%s, image=%s, price=%s]", id, brandName,
				color, size, image, price);
	}

}
