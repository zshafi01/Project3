<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
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
	min-width:200px;
	padding: 0 10px;
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
			<div class="card">
					<img src="../image/puma.jpg" alt="puma" style="width: 50%">
					<h5>PUMA</h5>
			
					<h6>$39</h6>
			</div>
			<div class="card">
					<img src="image/adidas.jpg" alt="adidas" style="width: 50%">
					<h5>ADIDAS</h5>
				
					<h6>$79</h6>
				</div>
			<div class="card">
					<img src="image/nike.jpg" alt="nike" style="width: 50%">
					<h5>NIKE</h5>
				
					<h6>$89</h6>
				</div>
			<div class="card">
					<img src="image/jordan.jpg" alt="jordan" style="width: 50%">
					<h5>JORDAN</h5>
					
					<h6>$110</h6>

				</div>
		</div>
		<div id="main-footer" class="row">
			<%@ include file="footer.jsp"%>
		</div>

</body>

</html>