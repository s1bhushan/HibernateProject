package com.service;

import java.util.List;

import com.dao.empDAO;
import com.dao.empDAOImpl;
import com.model.Employee;


public class EmpServiceDAOImpl implements EmployeeServiceDAO{

	empDAO dao = new empDAOImpl();

	public int DeleteData(int id) {
		int res = dao.DeleteData(id);

		if (res > 0) {
			System.out.println("Success Delete");
		} else {
			System.out.println("Fail to Delete");
		}
		return res;

	}

	public void ReadDatabyId(int id) {

		Employee bo = dao.ReadDatabyId(id);

		System.out.print("Details: " + bo);

	}

	public List<Employee>  ReadData() {

		List<Employee> bookList = dao.ReadData();

		return bookList;

	}
	
	

	public int UpdateData(Employee emp) {
		
		int res = dao.UpdateData(emp);

		if (res > 0) {
			System.out.println("Success Update");
		} else {
			System.out.println("Fail to Update");
		}
		return res;

	}

	public int addData(Employee emp) {


		int res = dao.addData(emp);

		if (res > 0) {
			System.out.println("Success Added");
		} else {
			System.out.println("Fail to Added");
		}
		return res;

	}

}
