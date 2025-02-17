package com.dao;

import java.util.List;

import com.model.Order;


public interface foodDAO {
	int addData(Order food);

	int DeleteData(int id);

	List<Order> ReadData();

	int UpdateData(Order food);

	Order ReadDatabyId(int id);
	
	boolean checkStudent(Order food);

}
