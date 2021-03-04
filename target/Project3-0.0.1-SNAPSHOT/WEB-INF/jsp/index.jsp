<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<style>
* {
	box-sizing: border-box;
}

body {
	font-family: Arial, Helvetica, sans-serif;
}

.card {
	float: left;
	width: 20%;
	height:200px;
	min-width:200px;
	padding: 0 10px;
}
.card img{
height: 160px;
}

.main {
	width: 100%;
}

#main-heade{
width: 100%;
}
#main-body{
width: 100%;
}
#main-footer{
width: 100%;
clear: left;
}
</style>
</head>
<body>
		<div id="main-header" class="row">
			<%@ include file="header.jsp"%>
		</div>

		<div id="main-body" class="row">
		<!-- for each shoes -->
		
		<c:forEach var="shoe" items="${allShoes}"> 
			<div class="card">
					<img src=<c:out value="${shoe.image}"/> alt="puma" style="width: 50%">
					<h5><c:out value="${shoe.brandName}"/></h5>
					<h5><c:out value="${shoe.size}"/></h5>
					<h5><c:out value="${shoe.color}"/></h5>
					<h6><c:out value="${shoe.price}"/></h6>
			</div>
		</c:forEach>
			
			
		</div>
		<div id="main-footer" class="row">
			<%@ include file="footer.jsp"%>
		</div>

</body>

</html>