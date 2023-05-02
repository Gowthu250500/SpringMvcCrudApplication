<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
    <%@ page import="com.techpalle.model.Student" %>
    <%@ page import="java.util.ArrayList" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Page</title>
</head>
<body>

	<% Student s = (Student)request.getAttribute("Student"); %>
	<h1>Edit Form</h1>
	<hr>
	
	<form action="update" method="post">
	
	<table>
	<tr>
		<td><input type="text" id="tbSno" name="tbSno" value="<%= s.getSno() %>" hidden="hidden" /></td>
	</tr>
	<tr>
		<td>Name:</td>
		<td><input type="text" id="tbName" name="tbName" value="<%= s.getSname() %>" required="required" /></td>
	</tr>
	<tr>
		<td>Email:</td>
		<td><input type="email" id="tbEmail" name="tbEmail" value="<%= s.getEmail() %>" required="required" /></td>
	</tr>
	<tr>
		<td>Password:</td>
		<td><input type="password" id="tbPass" name="tbPass" value="<%= s.getPassword() %>" required="required" /></td>
	</tr>
	<tr>
		<td>Mobile:</td>
		<td><input type="tel" id="tbMob" name="tbMob" value="<%= s.getMobile() %>" required="required" /></td>
	</tr>
	<tr>
		<td></td>
		<td><input type="submit" value="Update" /></td>
	</tr>
	</table>
	
	</form>

</body>
</html>