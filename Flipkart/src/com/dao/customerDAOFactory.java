package com.dao;


public class customerDAOFactory {

	public static customerDAO getInstance() {

		return new customerDAOImpl();
	}
}
