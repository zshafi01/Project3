<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<form method="post" action="shoes">

<table>
			<tr>
				<td>Brand-Name
				<td>
				<td><input type="text" name="brand_Name">
				<td>
			</tr>
			<tr>
				<td>Color
				<td>
				<td><input type="text" name="color">
				<td>
			</tr>
			<tr>
				<td>Size
				<td>
				<td><input type="text" name="size">
				<td>
			</tr>
			<tr>
				<td>Image
				<td>
				<td><input type="file" name="image">
				<td>
			</tr>
			<tr>
				<td>price
				<td>
				<td><input type="text" name="price">
				<td>
			</tr>

</table>
<input type="submit" value="save">

</form>
</body>
</html>