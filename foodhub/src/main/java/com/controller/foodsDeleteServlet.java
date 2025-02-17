package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.service.foodService;
import com.service.foodServiceImpl;

@WebServlet("/foodsDeleteServlet")
public class foodsDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private foodService serv;

	public void init() throws ServletException {
		serv = new foodServiceImpl();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		String idtrim = request.getParameter("id");
		
		
		int id=Integer.parseInt(idtrim.trim());
		
		
RequestDispatcher rd=request.getRequestDispatcher("/read.jsp"); 

		
		int res = serv.DeleteData(id);
		if (res > 0) {
			out.print("<h1>" + "SUCCESS Deleted!!!" + "</h1>");
			rd.include(request, response);
		} else {
			out.print("<h1>" + "FAILED TO Deleted!!!" + "</h1>");
		rd.include(request, response);
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

}
