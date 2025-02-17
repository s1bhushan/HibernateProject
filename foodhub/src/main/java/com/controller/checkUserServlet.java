package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/checkUserServlet")
public class checkUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		
		String name = request.getParameter("uname");
		
		String psw = request.getParameter("psw");
		
RequestDispatcher rd=request.getRequestDispatcher("/index.jsp"); 
RequestDispatcher rd1=request.getRequestDispatcher("/login.html"); 	
		
		/*if (name.equals("Admin")&&psw.equals("Admin2025")) {
			out.print("<h1>" + "Login Successful!!!" + "</h1>");
			
			rd.include(request, response);
			
		} else {
			out.print("<h1>" + "FAILED TO Login!!!" + "</h1>");
		rd1.include(request, response);
		}
		*/


if ("Admin".equals(name) && "Admin2025".equals(psw)) {
    HttpSession session = request.getSession();
    session.setAttribute("user", name); 
    response.sendRedirect("index.jsp");
} else {
    response.sendRedirect("login.jsp?error=Invalid username or password");
}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

}
