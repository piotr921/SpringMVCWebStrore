<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
    <title>Products</title>
</head>
<body>
<section>
    <div class="jumbotron">
        <a href="<c:url value="j_spring_security_logout"/>" class="btn btn-danger btn-mini pull-right">
            <spring:message code="addProduct.form.logout.label"/>
        </a>
        <div class="container">
            <h1>Products</h1>
            <p>Add product</p>
        </div>
    </div>
</section>
<section class="container">
    <form:form modelAttribute="newProduct" class="form-horizontal" enctype="multipart/form-data">
        <fieldset>
            <legend>Add new product</legend>
            <div class="form-group">
                <label class="control-label col-lg-2 col-lg-2" for="productId">
                    <spring:message code="addProduct.form.productId.label"/>
                </label>
                <div class="col-lg-10">
                    <form:input id="productId" path="productId" type="text" class="form:input-large"/>
                </div>
            </div>
            <div class="form-group">
                <label class="control-label col-lg-2 col-lg-2" for="name">
                    <spring:message code="addProduct.form.productName.label"/>
                </label>
                <div class="col-lg-10">
                    <form:input id="name" path="name" type="text" class="form:input-large"/>
                </div>
            </div>
            <div class="form-group">
                <label class="control-label col-lg-2 col-lg-2" for="unitPrice">
                    <spring:message code="addProduct.form.productUnitPrice.label"/>
                </label>
                <div class="col-lg-10">
                    <form:input id="unitPrice" path="unitPrice" type="text" class="form:input-large"/>
                </div>
            </div>
            <div class="form-group">
                <label class="control-label col-lg-2 col-lg-2" for="manufacturer">
                    <spring:message code="addProduct.form.productManufacturer.label"/>
                </label>
                <div class="col-lg-10">
                    <form:input id="manufacturer" path="manufacturer" type="text" class="form:input-large"/>
                </div>
            </div>
            <div class="form-group">
                <label class="control-label col-lg-2 col-lg-2" for="category">
                    <spring:message code="addProduct.form.productCategory.label"/>
                </label>
                <div class="col-lg-10">
                    <form:input id="category" path="category" type="text" class="form:input-large"/>
                </div>
            </div>
            <div class="form-group">
                <label class="control-label col-lg-2 col-lg-2" for="unitsInStock">
                    <spring:message code="addProduct.form.unitsInStock.label"/>
                </label>
                <div class="col-lg-10">
                    <form:input id="unitsInStock" path="unitsInStock" type="text" class="form:input-large"/>
                </div>
            </div>
            <div class="form-group">
                <label class="control-label col-lg-2" for="description">
                    <spring:message code="addProduct.form.productDescription.label"/>
                </label>
                <div class="col-lg-10">
                    <form:textarea id="description" path="description" rows="2"/>
                </div>
            </div>
            <div class="form-group">
                <label class="control-label col-lg-2" for="condition">
                    <spring:message code="addProduct.form.productState.label"/>
                </label>
                <div class="col-lg-10">
                    <form:radiobutton path="condition" value="New"/> <spring:message code="addProduct.form.productState.New.label"/>
                    <form:radiobutton path="condition" value="Old"/><spring:message code="addProduct.form.productState.Old.label"/>
                    <form:radiobutton path="condition" value="Refurbished"/><spring:message code="addProduct.form.productState.Refurbished.label"/>
                </div>
            </div>
            <div class="form-group">
                <label class="control-label col-lg-2" for="picture">
                    <spring:message code="addProduct.form.picture.label"/>
                </label>
                <div class="col-lg-10">
                    <form:input id="picture" path="picture" class="form:input-large"/>
                </div>
            </div>
            <div class="form-group">
                <div class="col-lg-offset-2 col-lg-10">
                    <input type="submit" id="btnAdd" class="btn btn-primary" value="Add"/>
                </div>
            </div>
        </fieldset>
    </form:form>
</section>
</body>
</html>