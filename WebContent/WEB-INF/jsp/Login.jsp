<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Log in</title>
</head>
<body>
	<form method="post" action="login">
		<table>

			<tr>
				<td>Email
				<td>
				<td><input type="email" name="email">
				<td>
			</tr>
			<tr>
				<td>Password
				<td>
				<td><input type="password" name="password">
				<td>
			</tr>

			<tr>
				<td colspan="2"><input type="submit" value="login"></td>
			</tr>
		</table>

	</form>

</body>
</html>