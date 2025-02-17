<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@page import="com.model.Employee"%>
<%@page import="com.service.EmployeeServiceDAO"%>
<%@page import="com.service.EmpServiceDAOImpl"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Iterator"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="./css/table.css">

</head>
<body>


	<%
	EmployeeServiceDAO ser = new EmpServiceDAOImpl();

	List<Employee> list = ser.ReadData();

	request.setAttribute("emplist", list);
	%>


	<table id="customers">
		<tr>
			<th>ID</th>
			<th>NAME</th>
			<th>SALARY</th>
			<th>Remove</th>
			<th>Update</th>
		</tr>

		<c:forEach var="employee" items="${requestScope.emplist}">
			<tr>

				<td>${employee.id}</td>
				<td>${employee.name}</td>
				<td>${employee.salary}</td>


				<td><a href=EmployeeDeleteServlet?id=${employee.id}>Delete</a></td>

				<td><a href=updateform.html?id=${employee.id}>UPDATE</a></td>

			</tr>

		</c:forEach>

	</table>

</body>
</html>