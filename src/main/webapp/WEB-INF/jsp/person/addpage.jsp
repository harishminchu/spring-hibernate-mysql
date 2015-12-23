<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="<c:url value='/css/bootstrap.css' />" rel="stylesheet">
<script src="<c:url value='/js/jquery.js'/>"></script>
<script src="<c:url value='/js/bootstrap.min.js'/>"></script>

<title>Insert title here</title>
</head>
<body>
<div class="container">
    <nav class="navbar navbar-default navbar-static-top" role="navigation">
        <ul class="nav navbar-nav">
            <c:url var="home" value="/login/person/persons" />
            <li class="active"><a href="${home}">person</a></li>
            <c:url var="logout" value="/login/UserLogin/login" />
        </ul>
        <div class="widget-head">
            <div class="pull-right">
                <a href="${logout} "> Logout </a>
            </div>
            <div class="clearfix"></div>
        </div>

    </nav>


<div>
	<h1>Person</h1>

	<c:url var="saveUrl" value="/login/person/persons/add" />

	<form:form modelAttribute="personAttribute" method="POST"
		action="${saveUrl}" class="form-horizontal" role="form">

		<div class="form-group">
			<label class="col-sm-2 control-label">ಹೆಸರು:</label>
			<div class="col-sm-6">
				<form:input tabindex="1" class="form-control " path="name" />
			</div>
		</div>
		<div class="form-group">
			<label class="col-sm-2 control-label">ಊರು :</label>
			<div class="col-sm-6">
				<form:input  tabindex="2" class="form-control " path="place" />
			</div>
		</div>

		<div class="form-group">
			<label class="col-sm-2 control-label"> ಮೊಬೈಲ್  :</label>
			<div class="col-sm-6">
				<form:input  class="form-control "  path="contact"  />
			</div>
		</div>
		<div class="form-group">
			<label class="col-sm-2 control-label"> ವಿಳಾಸ </label>
			<div class="col-sm-6">
                <form:textarea rows="6" class="form-control " path="address" />
			</div>
		</div>
      <div class="form-group">
            <label class="col-sm-2 control-label" style="text-align: right"
                   path="whoishe">ಯಾರು  ಇವರು</label>
            <div class="col-sm-4">
                <form:select class="form-control" path="whoishe" >
                    <form:option value="ಭಕ್ತ"></form:option>
                    <form:option value="ಸೇವಾಕರ್ತ"></form:option>
                </form:select>

            </div>
        </div>


        <div class="form-group">
            <label class="col-sm-2 control-label" style="text-align: right"
                   path="joinDate"> Join Date</label>
            <div class="col-sm-4">

                <form:input tabindex="3" type="date" class="form-control" path="joinDate"/>

            </div>
        </div>


        <div class="form-group">
			<div class="col-sm-offset-2 col-sm-10">
				<input  tabindex="4"class="btn btn-primary"  type="submit" value="Save" />
			</div>
		</div>

	</form:form>
</div>
</body>
</html>