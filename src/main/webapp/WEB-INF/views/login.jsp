<%@page pageEncoding="UTF-8" contentType="text/html; UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
    <title>Products</title>
</head>
<body>
<section>
    <div class="jumbotron">
        <div class="container">
            <h1>Products</h1>
            <p>Add product</p>
        </div>
    </div>
</section>
<div class="container">
    <div class="row">
        <div class="col-md-4 col-md-offset-4">
            <div class="panel panel-default">
                <div class="panel-heading">
                    <h3 class="panel-title"><spring:message code="login.form.title.label"/></h3>
                </div>
                <div class="panel-body">
                    <c:if test="${not empty error}">
                        <div class="alert alert-danger">
                            <spring:message code="AbstractUserDetailsAuthenticationProvider.badCredentials"/><br/>
                        </div>
                    </c:if>
                    <form action="<c:url value="/j_spring_security_check"></c:url> " method="post">
                        <fieldset>
                            <div class="form-control" placeholder=
                            <spring:message code="login.form.userName.label"/>
                                    name='j_username' type="text">
                            </div>
                            <div class="form-control" placeholder=
                            <spring:message code="login.form.userPassword.label"/>
                                    name='j_password' type="">
                            </div>
                            <input class="btn btn-lg btn-success btn-block"
                                   type="submit" value=
                                   <spring:message code="login.form.button.label"/>
                            >
                        </fieldset>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>