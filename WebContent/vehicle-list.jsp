<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>User Management Application</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
</head>
<body>

	<header>
		<nav class="navbar navbar-expand-md navbar-dark"
			style="background-color: black">
			<div>
				<a href="#" class="navbar-brand"> Vehicle
					Management App </a>
			</div>

<!-- 			<ul class="navbar-nav"> -->
<%-- 				<li><a href="<%=request.getContextPath()%>/list" --%>
<!-- 					class="nav-link">Vehicle</a></li> -->
<!-- 			</ul> -->
		</nav>
	</header>
	<br>

	<div class="row">

		<div class="container">
			<h3 class="text-center">List of Vehicles</h3>
			<hr>
			<div class="container text-left">

				<a href="<%=request.getContextPath()%>/new" class="btn btn-success">Add
					New Vehicle</a>
			</div>
			<br>
			<table class="table table-bordered">
				<thead>
					<tr>
						<th>ID</th>
						<th>Brand</th>
						<th>Model</th>
						<th>Type</th>
						<th>Price</th>
						<th>Quantity</th>
						<th>Actions</th>
					</tr>
				</thead>
				<tbody>
					<!--   for (Todo todo: todos) {  -->
					<c:forEach var="vehicle" items="${listVehicle}">

						<tr>
							<td><c:out value="${vehicle.id}" /></td>
							<td><c:out value="${vehicle.brand}" /></td>
							<td><c:out value="${vehicle.model}" /></td>
							<td><c:out value="${vehicle.type}" /></td>
							<td><c:out value="${vehicle.price}" /></td>
							<td><c:out value="${vehicle.quantity}" /></td>
							<td><a href="edit?id=<c:out value='${vehicle.id}' />">Edit</a>
								&nbsp;&nbsp;&nbsp;&nbsp; <a
								href="delete?id=<c:out value='${vehicle.id}' />">Delete</a></td>
						</tr>
					</c:forEach>
				</tbody>

			</table>
		</div>
	</div>
</body>
</html>