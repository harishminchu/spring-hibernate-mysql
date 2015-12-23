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
<div class="container">
	<nav class="navbar navbar-default navbar-static-top" role="navigation">
	<ul class="nav navbar-nav">
		<c:url var="home" value="/login/proctor/proctors" />
		<li class="active" ><a href="${home}">Proctor</a></li>
		<c:url var="logout" value="/login/UserLogin/login" />
	</ul>
	<div class="widget-head">
				<div class="pull-right">
				<a href="${logout} ">
				Logout
				</a>
				</div>
				<div class="clearfix"></div>
			</div>
	</nav>
	<div>

		<h1>Create New Proctor</h1>

		<c:url var="saveUrl" value="/login/proctor/proctors/add" />
		<form:form class="form-horizontal" role="form"
			modelAttribute="proctorAttribute" method="POST" action="${saveUrl}">

			<div class="form-group">
				<label class="col-sm-2 control-label" style="text-align: left"
					path="name">Proctor Name:</label>
				<div class="col-sm-4">
					<form:input class="form-control " path="name" />
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-2 control-label" style="text-align: left"
					path="deparment">Proctor Department</label>
				<div class="col-sm-4">
					<form:select class="form-control" path="deparment">

						<option value="EC">ELectronic And Communication</option>
						<option value="CS">Computer Science</option>
						<option value="IS">Information Science</option>
						<option value="MH">Mechanical</option>

					</form:select>

				</div>
			</div>
			<div class="form-group">
				<td><form:label class="col-sm-2 control-label"
						style="text-align:left" path="contact">Proctor Contact</form:label></td>
				<div class="col-sm-4">
					<td><form:input class="form-control" path="contact" /></td>
				</div>
			</div>
			<div class="form-group">
				<td><form:label class="col-sm-2 control-label"
						style="text-align:left" path="email">Email </form:label></td>
				<div class="col-sm-4">
					<td><form:input class="form-control" path="email" /></td>
				</div>
			</div>
			<div class="form-group">
				<td><form:label class="col-sm-2 control-label"
						style="text-align:left" path="password">Password</form:label></td>
				<div class="col-sm-4">
					<td><form:password class="form-control" path="password" /></td>
				</div>
			</div>

			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-10">
					<input type="submit" class="btn btn-primary" value="Save" />
				</div>
			</div>
		</form:form>
	</div>
</div>

</body>
</html>