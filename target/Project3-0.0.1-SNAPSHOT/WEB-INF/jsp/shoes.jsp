<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Manage Shoes</title>
</head>
<body>

	<div align="center">
		<h2>Shoes Manager</h2>
		<h3>
			<a href="addshoes">Add Shoes</a>
		</h3>
		<table border="1" cellpadding="5">
			<tr>
				<th>ID</th>
				<th>Brand Name</th>
				<th>Color</th>
				<th>Size</th>
				<th>Image</th>
				<th>price</th>
				<th>Action</th>
			</tr>

			<c:forEach items="${shoes}" var="shoes">
				<tr>
					<td>${shoes.id}</td>
					<td>${shoes.brandName}</td>
					<td>${shoes.color}</td>
					<td>${shoes.size}</td>
					<td>${shoes.image}</td>
					<td>${shoes.price}</td>


					<td><a href="updateshoes?id=${shoes.id}">Edit</a>
						&nbsp;&nbsp;&nbsp;&nbsp;
					<a	href="deleteshoes?id=${shoes.id}">Delete</a></td>
				</tr>
			</c:forEach>

		</table>
	</div>
</body>
</html>