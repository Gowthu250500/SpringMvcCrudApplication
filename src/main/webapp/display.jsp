<%@page import="java.sql.Array"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
    <%@ page import="com.techpalle.model.Student" %>
    <%@ page import="java.util.ArrayList" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Display Page</title>
</head>
<body>

<h1>Student List:</h1>
<hr>

<table border="1" cellspacing="0">

	<thead>
		<tr>
			<th>Sno</th>
			<th>Name</th>
			<th>Email</th>
			<th>Password</th>
			<th>Mobile No</th>
			<th>Actions</th>
		</tr>
	</thead>
	
	<tbody>
	<% ArrayList<Student> s =(ArrayList<Student>)request.getAttribute("student");%>
	<%
		for(Student item : s)
		{
	%>
			<tr>
				<td><c:out value="<%= item.getSno() %>"></c:out></td>
				<td><c:out value="<%= item.getSname() %>"></c:out></td>
				<td><c:out value="<%= item.getEmail() %>"></c:out></td>
				<td><c:out value="<%= item.getPassword() %>"></c:out></td>
				<td><c:out value="<%= item.getMobile() %>"></c:out></td>
				<td>
					<a href="editForm?sno=<c:out value="<%= item.getSno()%>"></c:out>">Edit</a>
					&nbsp; &nbsp;
					<a href="deleteForm?sno=<c:out value="<%= item.getSno()%>"></c:out>">Delete</a>
				</td>
			</tr>
	<%
		}
	%>
	</tbody>
	
</table>

</body>
</html>