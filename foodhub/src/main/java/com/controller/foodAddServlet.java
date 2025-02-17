package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model.Order;
import com.service.foodService;
import com.service.foodServiceImpl;



@WebServlet("/foodAddServlet")
public class foodAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private foodService serv;

	public void init() throws ServletException {
		serv = new foodServiceImpl();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
        
		int id=Integer.parseInt(request.getParameter("id"));
		String Name=request.getParameter("name");
		String Pname=request.getParameter("pname");
		int qty=Integer.parseInt(request.getParameter("qty"));
		double price=Double.parseDouble(request.getParameter("price"));

		Order food=new Order(id,Name,Pname,qty,price);
		
		RequestDispatcher rd=request.getRequestDispatcher("/read.jsp"); 
		
		int res = serv.addData(food);
		if (res > 0) {
			out.print("<h1>" + "SUCCESS ADD!!!" + "</h1>");
			rd.include(request, response);
		} else {
			out.print("<h1>" + "FAILED TO ADD!!!" + "</h1>");
		rd.include(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

}
