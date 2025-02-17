package com.model;

import java.io.Serializable;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "food")
public class Order implements Serializable{
	@Id
	@Column(name = "Id")
	private int id;
	@Column(name = "Name")
	private String name;
	@Column(name = "product_name")
	private String product_name;
	@Column(name = "Quantity")
	private int qty;
	@Column(name = "Price")
	private double price;
	
	
	
	public Order(int id, String name, String product_name, int qty, double price) {
		super();
		this.id = id;
		this.name = name;
		this.product_name = product_name;
		this.qty = qty;
		this.price = price;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getProduct_name() {
		return product_name;
	}
	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}
	public int getQty() {
		return qty;
	}
	public void setQty(int qty) {
		this.qty = qty;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	@Override
	public String toString() {
		return "Order [id=" + id + ", name=" + name + ", product_name=" + product_name + ", qty=" + qty + ", price="
				+ price + "]";
	}
	public Order() {
		
	}
	

}
