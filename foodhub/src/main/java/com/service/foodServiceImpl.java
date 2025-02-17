package com.service;

import java.util.ArrayList;
import java.util.List;

import com.dao.foodDAO;
import com.dao.foodDAOImpl;
import com.model.Order;

public class foodServiceImpl implements foodService{
foodDAO dao=new foodDAOImpl();
	@Override
	public int addData(Order order) {
		int res=dao.addData(order);
		if (res > 0) {
			System.out.println("Success Added");
		} else {
			System.out.println("Fail to Added");
		}
		return res;
	}

	@Override
	public int DeleteData(int id) {
		int res = dao.DeleteData(id);

		if (res > 0) {
			System.out.println("Success Delete");
		} else {
			System.out.println("Fail to Delete");
		}
		return res;
	}

	@Override
	public List<Order> ReadData() {
		List<Order> foodList = dao.ReadData();

		return foodList;
	}

	@Override
	public int UpdateData(Order order) {
		int res = dao.UpdateData(order);

		if (res > 0) {
			System.out.println("Success Update");
		} else {
			System.out.println("Fail to Update");
		}
		return res;
	}

	@Override
	public List<Order> ReadDatabyId(int id) {
		Order bo = dao.ReadDatabyId(id);
		
	       List<Order> list=new ArrayList<>();
	       list.add(bo);
	       

			System.out.print("Details: " + bo);
			return list;
	}

}
