<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Manage Customer</title>
</head>
<body>

	<div align="center">
		<h2>Customer Manager</h2>
	
		<table border="1" cellpadding="5">
			<tr>
				<th>ID</th>
				<th> Name</th>
				<th>Email</th>
				<th>Password</th>
				<th>Street</th>
				<th>City</th>
				<th>Zipcode</th>
				<th>Country</th>
				<th>Action</th>
			</tr>

			<c:forEach items="${customer}" var="customerlist">
				<tr>
					<td>${customer.id}</td>
					<td>${customer.name}</td>
					<td>${customer.email}</td>
					<td>${customer.street}</td>
					<td>${customer.city}</td>
					<td>${customer.zipcode}</td>
					<td>${customer.country}</td>
					<td>${customer.userId}</td>
					<td>${customer.approved}</td>
					
					
					<td><a href="customerupdate?id=${customer.id}">Edit</a>
						&nbsp;&nbsp;&nbsp;&nbsp;
					<a	href="deletecustomer?id=${customer.id}">Delete</a></td>
				</tr>
			</c:forEach>

		</table>
	</div>
</body>
</html>