<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@page pageEncoding="UTF-8" contentType="text/html; UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet"
	href="//netdna.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css">
<title>Product</title>
</head>
<body>
	<section>
		<div class="jumbotron">
			<div class="container">
				<h1>Product</h1>
			</div>
		</div>
	</section>
	<section class="container">
		<div class="row">
			<div class="col-md-5">
				<h3>${product.name}</h3>
				<p>${procuct.descrription}</p>
				<p>
					<strong>Product code: </strong> <span class="label label-warning">${product.productId}</span>
				</p>
				<p>
					<strong>Manufacturer: </strong> ${product.manufacturer}
				</p>
				<p>
					<strong>Category: </strong> ${product.category}
				</p>
				<p>
					<strong>Number of available items: </strong>
					${product.unitsInStock}
				</p>
				<h4>${product.unitPrice}PLN</h4>
				<p>
					<a href="#" class="btn btn-warning btn-large"> <span
						class="glyphicon-shopping-cart glyphicon"></span> Buy now
					</a>
				</p>
				<a href="<spring:url value="/products" />" class="btn btndefault">
					<span class="glyphicon-hand-left glyphicon"></span> Go back
				</a>
			</div>
		</div>
	</section>
</body>
</html>