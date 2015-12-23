<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script
	src="https://ajax.googleapis.com/ajax/libs/angularjs/1.0.8/angular.min.js"></script>
<link href="<c:url value='/css/bootstrap.css' />" rel="stylesheet">
<!-- Custom styles for this template -->
<link href="<c:url value='/css/jumbotron.css' />" rel="stylesheet">
</head>
<body>
Enterd The Wrong User Name OR Password

<c:url var="url" value="/login/UserLogin/login" />

<a href="${ url}">Click me to redirect</a>
</body>
</html>