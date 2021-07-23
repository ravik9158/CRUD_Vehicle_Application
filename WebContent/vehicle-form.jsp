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
				<a href="/" class="navbar-brand"> Vehicle Management App </a>
			</div>

			<ul class="navbar-nav">
				<li><a href="<%=request.getContextPath()%>/list"
					class="nav-link">Vehicles</a></li>
			</ul>
		</nav>
	</header>
	<br>
	<div class="container col-md-5">
		<div class="card">
			<div class="card-body">
				<c:if test="${vehicle != null}">
					<form action="update" method="post">
				</c:if>
				<c:if test="${vehicle == null}">
					<form action="insert" method="post">
				</c:if>
				<caption>
					<h2>
						<c:if test="${vehicle != null}">
            				Edit Vehicle
            			</c:if>
						<c:if test="${vehicle == null}">
            				Add New Vehicle
            			</c:if>
					</h2>
				</caption>

				<c:if test="${vehicle != null}">
					<input type="hidden" name="id" value="<c:out value='${vehicle.id}' />" />
				</c:if>

				<fieldset class="form-group">
					<label>Brand</label> 
					<input type="text" value="<c:out value='${vehicle.brand}' />" 
					class="form-control"
					name="brand" required="required">
				</fieldset>

				<fieldset class="form-group">
					<label>Model</label> 
					<input type="text" value="<c:out value='${vehicle.model}' />" 
					class="form-control"
					name="model">
				</fieldset>

				<fieldset class="form-group">
					<label>Type</label> 
					<input type="text" value="<c:out value='${vehicle.type}' />" 
					class="form-control"
					name="type">
				</fieldset>
				
				<fieldset class="form-group">
					<label>Price(INR)</label> 
					<input type="text" value="<c:out value='${vehicle.price}' />" 
					class="form-control"
					name="price">
				</fieldset>
				
				<fieldset class="form-group">
					<label>Quantity</label> 
					<input type="text" value="<c:out value='${vehicle.quantity}' />" 
					class="form-control"
					name="quantity">
				</fieldset>

				<button type="submit" class="btn btn-success">Save</button>
				</form>
			</div>
		</div>
	</div>
</body>
</html>