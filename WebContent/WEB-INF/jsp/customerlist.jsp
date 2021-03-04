<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Manage Customer</title>
</head>
<body>
<div id="main-header" class="row">
		<%@ include file="header2.jsp"%>
	</div>

	<div align="center">
		<h2>Customer Manager</h2>

		<table border="1" cellpadding="5">
			<tr>
				<th>ID</th>
				<th>Name</th>
				<th>Email</th>
				<th>Street</th>
				<th>City</th>
				<th>Zipcode</th>
				<th>Country</th>
				<th>UserID</th>
				<th>Approved</th>
				<th>Action</th>
				<th>Status</th>
			</tr>

			<c:forEach items="${customerlist}" var="customer">
				<tr>
					<td>${customer.id}</td>
					<td>${customer.custName}</td>
					<td>${customer.email}</td>
					<td>${customer.street}</td>
					<td>${customer.city}</td>
					<td>${customer.zipcode}</td>
					<td>${customer.country}</td>
					<td>${customer.userId}</td>
					<td>${customer.approved}</td>


					<td><a href="customerupdate?id=${customer.id}">Edit</a>
						&nbsp;&nbsp;&nbsp;&nbsp; <a
						href="deletecustomer?id=${customer.id}">Delete</a></td>
					<td><c:if test="${customer.approved=='F'}">
							<a href="changestate?id=${customer.id}&state=T">Approve</a>
						</c:if> <c:if test="${customer.approved=='T'}">
							<a href="changestate?id=${customer.id}&state=F">DisApprove</a>
						</c:if></td>
				</tr>
			</c:forEach>

		</table>
	</div>
</body>
</html>