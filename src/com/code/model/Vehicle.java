package com.code.model;

public class Vehicle {

	private int id;
	private String brand;
	private String model;
	private String type;
	private String price;
	private String quantity;
	
	public Vehicle(String brand, String model, String type, String price, String quantity) {
		super();
		this.brand = brand;
		this.model = model;
		this.type = type;
		this.price = price;
		this.quantity = quantity;
	}
	public Vehicle(int id, String brand, String model, String type, String price, String quantity) {
		super();
		this.id = id;
		this.brand = brand;
		this.model = model;
		this.type = type;
		this.price = price;
		this.quantity = quantity;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getQuantity() {
		return quantity;
	}
	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}
	
	
}
