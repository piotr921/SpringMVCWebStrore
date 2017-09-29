<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
    <title>Add Picture</title>
</head>
<body>
<section class="container">
    <form:form modelAttribute="update" class="form-horizontal" enctype="multipart/form-data">
        <fieldset>
            <legend>Add picture</legend>
            <div class="form-group">
                <label class="control-label col-lg-2" for="picture">
                    <spring:message code="addProduct.form.picture.label"/>
                </label>
                <div class="col-lg-10">
                    <form:input id="picture" path="picture" type="file" class="form:input-large"/>
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
