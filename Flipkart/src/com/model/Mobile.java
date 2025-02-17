package com.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value = "Mo")


public class Mobile extends Customer {

	private String mname;
	private double price;
	public Mobile(String mname, double price) {
		super();
		this.mname = mname;
		this.price = price;
	}
	
	
	public Mobile() {
		super();
	}



	
	public String getMname() {
		return mname;
	}


	public void setMname(String mname) {
		this.mname = mname;
	}


	public double getPrice() {
		return price;
	}


	public void setPrice(double price) {
		this.price = price;
	}


	@Override
	public String toString() {
		return "Mobile [mname=" + mname + ", price=" + price + "]";
	}
	
	
}
