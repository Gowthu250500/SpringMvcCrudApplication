<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
    <%@ page import="com.techpalle.model.Student" %>
    <%@ page import="java.util.ArrayList" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registration Page</title>
</head>
<body>

	<h1>Welcome To Registration</h1>
	<hr>
	
	<form action="insert" method="post">
	<table>
	<tr>
		<td> <input type="text" id="tbSno" name="tbSno" hidden="hidden" /> </td>
	</tr>
	<tr>
		<td>Name:</td>
		<td><input type="text" id="tbName" name="tbName" required="required" /></td>
	</tr>
	<tr>
		<td>Email:</td>
		<td><input type="email" id="tbEmail" name="tbEmail" required="required" /></td>
	</tr>
	<tr>
		<td>Password:</td>
		<td><input type="password" id="tbPass" name="tbPass" required="required" /></td>
	</tr>
	<tr>
		<td>Mobile:</td>
		<td><input type="tel" id="tbMob" name="tbMob" required="required" /></td>
	</tr>
	<tr>
		<td></td>
		<td><input type="submit" value="Save"></td>
	</tr>
	</table>
	</form>

</body>
</html>