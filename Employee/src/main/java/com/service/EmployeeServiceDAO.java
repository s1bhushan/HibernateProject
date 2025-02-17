package com.service;

import java.util.List;

import com.model.Employee;

public interface EmployeeServiceDAO {
	
		int DeleteData(int id);
		void ReadDatabyId(int id);
		List<Employee>  ReadData();
		int UpdateData(Employee emp);
		int addData(Employee emp);
	}



