package com.dyashin.javaassessments.restaurants.dto;

public class Food {
	private int id;
	private String name;
	private String type;
	private String description;
	private int cost;
	private String quantity;

	public Food(int id, String name, String type, String description, int cost, String quantity) {
		super();
		this.id = id;
		this.name = name;
		this.type = type;
		this.description = description;
		this.cost = cost;
		this.quantity = quantity;
	}
	public Food(String name, String type, String description, int cost, String quantity) {
		super();
		this.name = name;
		this.type = type;
		this.description = description;
		this.cost = cost;
		this.quantity = quantity;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}

	public String getQuantity() {
		return quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}
	@Override
	public String toString() {
		return "Food [id=" + id + ", name=" + name + ", type=" + type + ", description=" + description + ", cost="
				+ cost + ", quantity=" + quantity + "]";
	}


}