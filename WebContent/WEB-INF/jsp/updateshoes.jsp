<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update Shoes</title>
</head>
<body>
	<div id="main-header" class="row">
		<%@ include file="header1.jsp"%>
	</div>
	<form:form method="POST" action="updateshoes" modelAttribute="shoes">

		<table>
			<tr>
				<td><form:label path="id"> ID</form:label></td>
				<td><form:input path="id" name="id" value="${shoes.id}" /></td>
			</tr>
			<tr>
				<td><form:label path="brandName">Brand Name</form:label></td>
				<td><form:input path="brandName" name="brandName"
						value="${shoes.brandName}" /></td>
			</tr>
			<tr>
				<td><form:label path="color">Color</form:label></td>
				<td><form:input path="color" name="color"
						value="${shoes.color}" /></td>
			</tr>
			<tr>
				<td><form:label path="size">Size</form:label></td>
				<td><form:input path="size" name="size" value="${shoes.size}" /></td>
			</tr>
			<tr>
				<td><form:label path="image">Upload Image</form:label></td>
				<td><form:input path="image" name="image"
						value="${shoes.image}" /></td>
			</tr>

			<tr>
				<td><form:label path="price">Price</form:label></td>
				<td><form:input path="price" name="price"
						value="${shoes.price}" /></td>
			</tr>
			<tr>
				<td><input type="submit" value="save"></td>
			</tr>
		</table>
	</form:form>

</body>
</html>