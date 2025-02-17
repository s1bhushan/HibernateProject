package com.app;


import com.dao.customerDAO;
import com.dao.customerDAOFactory;
import com.model.Fashion;
import com.model.Laptop;
import com.model.Mobile;

public class App {
	
	public static void main(String[] args) {
		
		customerDAO dao=customerDAOFactory.getInstance();
		
		Fashion fas=new Fashion();
		
		fas.setId(1111);
		fas.setName("Sakshi");
		fas.setGender("Female");
		fas.setAddress("Pune");
		fas.setFname("Bodycon");
		fas.setPrice(850);
		
	  dao.saveFashion(fas);
	  
	  System.out.println("----------Fashion SAVED------------------");
		
	  
	  Mobile mob=new Mobile();
		
	  mob.setId(2222);
	  mob.setName("Bhushan");
	  mob.setGender("Male");
	  mob.setAddress("Pune");
	  mob.setMname("Vivo T3");
	  mob.setPrice(18000);
		
	  dao.saveMobile(mob);
	  
	  System.out.println("----------Mobile SAVED------------------");
		
	  Laptop lap=new Laptop();
		
	  lap.setId(3333);
	  lap.setName("Rahul");
	  lap.setGender("Male");
	  lap.setAddress("Nashik");
	  lap.setLname("Dell");
	  lap.setPrice(75000);
		
	  dao.saveLaptop(lap);
	  
	  System.out.println("----------Laptop SAVED------------------");
		
	}

}
