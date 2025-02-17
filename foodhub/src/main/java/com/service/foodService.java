package com.service;

import java.util.List;

import com.model.Order;

public interface foodService {

	
	int addData(Order order);

	int DeleteData(int id);
	
	List<Order> ReadData();
	
	int UpdateData(Order order);
	List<Order> ReadDatabyId(int id);
}
