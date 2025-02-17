<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  <%@ page import="javax.servlet.http.HttpSession" %>
<%
    HttpSession sessionObj = request.getSession(false);
    if (sessionObj == null || sessionObj.getAttribute("user") == null) {
        response.sendRedirect("login.jsp");
    }
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="./css/login.css">

</head>
<body bgcolor="lightblue">

<h1>
		<a href="adddata.html">Add Food Data</a>
	</h1>
<hr>


<h1>
		<a href="update.jsp">Update Food Data</a>
	</h1>
<hr>


<h1>
		<a href="read.jsp">READ ALL</a>
	</h1>
<hr>
<form action="foodsDeleteServlet" method="get">

		ID : <input type="text" name="id"> <br> 
		
		<input type="submit"  value="SUBMIT">
</form>
<hr>
<hr>
<h1>Student Read Enter ID to Read</h1>
<form action="readbyId.jsp" method="get">

		ID : <input type="text" name="id"> <br> 
		
		<input type="submit"  value="SUBMIT">
</form>
<hr>
</body>
</html>