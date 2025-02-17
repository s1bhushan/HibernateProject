package com.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value = "La")

public class Laptop extends Customer{
	private String lname;
	private double price;
	public Laptop(String lname, double price) {
		super();
		this.lname = lname;
		this.price = price;
	}
	
	
	public Laptop() {
		super();
	}


	
	public String getLname() {
		return lname;
	}


	public void setLname(String lname) {
		this.lname = lname;
	}


	public double getPrice() {
		return price;
	}


	public void setPrice(double price) {
		this.price = price;
	}


	@Override
	public String toString() {
		return "Laptop [lname=" + lname + ", price=" + price + "]";
	}
	
	

}
