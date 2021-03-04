<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>add shoes</title>
</head>
<body>
	<div id="main-header" class="row">
		<%@ include file="header1.jsp"%>
	</div>

	<form:form action="addshoes" method="post" modelAttribute="shoes">

		<table>

			<tr>
				<td><form:label path="brandName">Brand Name</form:label></td>
				<td><input type="text" name="brandName" /></td>
			</tr>
			<tr>
				<td><form:label path="color">Color</form:label></td>
				<td><input type="text" name="color" /></td>
			</tr>
			<tr>

				<td><form:label path="size">Size</form:label></td>
				<td><input type="text" name="size" /></td>
			</tr>
			<tr>
				<td><form:label path="image">upload image</form:label></td>
				<td><input type="file" name="image" /></td>
			</tr>
			<tr>
				<td><form:label path="price">Price</form:label></td>
				<td><input type="text" name="price" /></td>
			</tr>

		</table>
		<input type="submit" value="save">

	</form:form>
</body>
</html>