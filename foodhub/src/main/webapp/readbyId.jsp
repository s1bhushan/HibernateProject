<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    
<%@page import="com.model.Order"%>
<%@page import="com.service.foodService"%>
<%@page import="com.service.foodServiceImpl"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Iterator"%>



<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
    
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="./css/login.css">

</head>
<body>


	<%int id=Integer.parseInt(request.getParameter("id"));

	
	%>
	
	
	<%
	foodService ser = new foodServiceImpl();

	List<Order> list = ser.ReadData();
 %>
	<%

	request.setAttribute("foodlist", list);
	%>


		
<h1>
		<a href="adddata.html">Add Data</a>
	</h1>
<hr>
	
	<table id="customers">
		<tr>
			<th>ID</th>
			<th>NAME</th>
			<th>Product</th>
			<th>Quantity</th>
			<th>Price</th>
			<th>Remove</th>
			<th>Update</th>
		</tr>

		<c:forEach var="food" items="${requestScope.foodlist}">
			<tr>

					<td>${food.id}</td>
				<td>${food.name}</td>
				<td>${food.product_name}</td>
				<td>${food.qty}</td>
				<td>${food.price}</td>


				<td><a href=foodsDeleteServlet?id=${food.id}>Delete</a></td>

				<td><a href=update.html?id=${food.id}>UPDATE</a></td>

			</tr>

		</c:forEach>

	</table>
</body>
</html>