package com.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value = "Fa")
public class Fashion extends Customer{
	
	private String fname;
	private double price;
	public Fashion(String fname, double price) {
		super();
		this.fname = fname;
		this.price = price;
	}
	
	
	public Fashion() {
		super();
	}


	
	public String getFname() {
		return fname;
	}


	public void setFname(String fname) {
		this.fname = fname;
	}


	public double getPrice() {
		return price;
	}


	public void setPrice(double price) {
		this.price = price;
	}


	@Override
	public String toString() {
		return "Fashion [fname=" + fname + ", price=" + price + "]";
	}
	
	

}
