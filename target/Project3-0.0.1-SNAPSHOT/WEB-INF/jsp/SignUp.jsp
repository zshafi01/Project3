<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
	
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Sign Up</title>
</head>
<body>
	<form method="post" action="signupSave">
		<table>
			<tr>
				<td>Name
				<td>
				<td><input type="email" name="name">
				<td>
			</tr>
			<tr>
				<td>Address
				<td>
				<td><input type="email" name="name">
				<td>
			</tr>
			<tr>
				<td>Email
				<td>
				<td><input type="email" name="name">
				<td>
			</tr>
			<tr>
				<td>Password
				<td>
				<td><input type="password" name="password">
				<td>
			</tr>
			<tr>
				<td class="select">Type</td>
				<td><select name="type">
						<option value="admin">Admin</option>
						<option value="customer">Customer</option>
				</select></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="SignUp"></td>
			</tr>
			

		</table>

	</form>

</body>
</html>

