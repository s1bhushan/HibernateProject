package com.dao;

import java.util.List;

import com.model.Employee;

public interface empDAO {
	int DeleteData(int id);
	Employee ReadDatabyId(int id);
	List<Employee> ReadData();
	int UpdateData(Employee emp);
	int addData(Employee emp);

}
