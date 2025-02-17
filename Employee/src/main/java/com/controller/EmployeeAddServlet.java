package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.model.Employee;
import com.service.EmpServiceDAOImpl;
import com.service.EmployeeServiceDAO;

@WebServlet("/EmployeeAddServlet")
public class EmployeeAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private EmployeeServiceDAO serv;

	@Override
	public void init() throws ServletException {

		serv = new EmpServiceDAOImpl();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		int id=Integer.parseInt(request.getParameter("id"));
		String name=request.getParameter("name");
		double salary=Double.parseDouble(request.getParameter("salary"));
		
		Employee stu=new Employee(id,name,salary);
		
RequestDispatcher rd=request.getRequestDispatcher("/Read.jsp"); 

		
		int res = serv.addData(stu);
		if (res > 0) {
			out.print("<h1>" + "SUCCESS ADD!!!" + "</h1>");
			rd.include(request, response);
		} else {
			out.print("<h1>" + "FAILED TO ADD!!!" + "</h1>");
		rd.include(request, response);
		}
		
	}

}
