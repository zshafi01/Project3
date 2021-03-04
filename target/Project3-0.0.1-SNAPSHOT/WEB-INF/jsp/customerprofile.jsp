<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update Customer</title>
</head>
<body>
	<div id="main-header" class="row">
		<%@ include file="header.jsp"%>
	</div>
	<form:form method="POST" action="customerupdate"
		modelAttribute="customer">

		<table>

			<tr>
				<td>ID</td>
				<td>
				
					<form:hidden path="id" />
					</td>
			</tr>

			<tr>
				<td><form:label path="custName"> Name</form:label></td>
				<td><form:input path="custName" name="custName"
						value="${customer.custName}" /></td>
			</tr>
			<tr>
				<td><form:label path="email">Email</form:label></td>
				<td><form:input path="email" name="email"
						value="${customer.email}" />
			</tr>

			<tr>
				<td><form:label path="street">Street</form:label></td>
				<td><form:input path="street" name="street"
						value="${customer.street}" />
			</tr>
			<tr>
				<td><form:label path="city">City</form:label></td>
				<td><form:input path="city" name="city"
						value="${customer.city}" />
			</tr>
			<tr>
				<td><form:label path="zipcode">Zip Code</form:label></td>
				<td><form:input path="zipcode" name="zipcode"
						value="${customer.zipcode}" />
			</tr>


			<tr>

				<td><form:label path="country">Country</form:label></td>
				<td><select name="country">
						<option value="USA">USA</option>
						<option value="Ethiopia">Ethiopia</option>
						<option value="India">India</option>
				</select></td>
			</tr>
			<tr>

				<td><form:label path="userId">User id</form:label></td>
				<td><form:input path="userId" name="userId"
						value="${customer.userId}" />
			</tr>


		</table>
		<input type="submit" value="save">

	</form:form>

</body>
</html>