package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.service.EmpServiceDAOImpl;
import com.service.EmployeeServiceDAO;

@WebServlet("/EmployeeDeleteServlet")
public class EmployeeDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private EmployeeServiceDAO dao;

	@Override
	public void init() throws ServletException {

		dao = new EmpServiceDAOImpl();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		String idtrim = request.getParameter("id");
		
		
		int id=Integer.parseInt(idtrim.trim());
		
		
RequestDispatcher rd=request.getRequestDispatcher("/Read.jsp"); 

		
		int res = dao.DeleteData(id);
		if (res > 0) {
			out.print("<h1>" + "SUCCESS Deleted!!!" + "</h1>");
			rd.include(request, response);
		} else {
			out.print("<h1>" + "FAILED TO Deleted!!!" + "</h1>");
		rd.include(request, response);
		}
		
	}

}
