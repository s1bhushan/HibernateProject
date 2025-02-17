<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
    <%@page import="com.model.Employee"%>
<%@page import="com.service.EmployeeServiceDAO"%>
<%@page import="com.service.EmpServiceDAOImpl"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Iterator"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="./css/table.css">

</head>
<body>

	<%

int id=Integer.parseInt(request.getParameter("id"));
String Name=request.getParameter("name");
double salary=Double.parseDouble(request.getParameter("salary"));


 %>

	<%
	EmployeeServiceDAO ser = new EmpServiceDAOImpl();
	Employee emp=new Employee(id,Name,salary);
	

	
	int res = ser.UpdateData(emp);
	if (res > 0) {
		out.print("<h1>" + "SUCCESS Update!!!" + "</h1>");
	
	} else {
		out.print("<h1>" + "FAILED TO Update!!!" + "</h1>");
	
	}
 %>


	<%
	

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

				<c:set var="num" value="${employee.id}"></c:set>
				
				<td><a href=EmployeeDeleteServlet?id=${employee.id}>Delete</a></td>
			

				<td><a href=updateform.html?id=${employee.id}>UPDATE</a></td>
			</tr>

		</c:forEach>

	</table>



</body>
</html>