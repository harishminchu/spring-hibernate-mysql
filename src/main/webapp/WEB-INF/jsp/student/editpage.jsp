<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
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
			<c:url var="home" value="/login/student/students" />
			<li class="active"><a href="${home}">Student</a></li>
		<c:url var="logout" value="/login/UserLogin/login" />
		</ul>
		<div class="widget-head">
			<div class="pull-right">
				<a href="${logout} "> Logout </a>
			</div>
			<div class="clearfix"></div>
		</div>

		</nav>

		<div class="">


			<h1>Edit student</h1>



<c:url var="saveUrl" value="/login/student/students/edit?id=${studentAttribute.id}" />
<form:form class="form-horizontal" role="form"
				modelAttribute="studentAttribute" method="POST" action="${saveUrl}">
				<div class="form-group">
					<form:label class="col-sm-2 control-label"
						style="text-align:left;padding-left:5px;" path="NAME">Student Name:</form:label>
					<div class="col-sm-2">
						<form:input class="form-control" path="NAME" />
					</div>
					<form:label class="col-sm-2 control-label" style="text-align:left"
						path="usnNumber">USN Number</form:label>
					<div class="col-sm-2">
						<form:input class="form-control" path="usnNumber" />
					</div>
					<form:label class="col-sm-2 control-label" style="text-align:left"
						path="contact">Contact Number</form:label>
					<div class="col-sm-2">
						<form:input class="form-control" path="contact" />
					</div>
				</div>
				<div class="form-group">
					<form:label class="col-sm-2 control-label" style="text-align:left"
						path="email">Email</form:label>
					<div class="col-sm-2">
						<form:input class="form-control" path="email" />
					</div>
					<form:label class="col-sm-2 control-label" style="text-align:left"
						path="internal">Internal</form:label>
					<div class="col-sm-2">
						<form:input class="form-control" path="internal"/>
					</div>
				</div>
				<div class="form-group">
					<form:label class="col-sm-2 control-label" style="text-align:left"
						path="subject1">Subject 1</form:label>
					<div class="col-sm-2">
						<form:input class="form-control" path="subject1" />
					</div>
					<form:label class="col-sm-2 control-label" style="text-align:left"
						path="mark1">Marks</form:label>
					<div class="col-sm-2">
						<form:input class="form-control" path="mark1" />
					</div>
					<form:label class="col-sm-2 control-label" style="text-align:left"
						path="percentageoaattendanceforsubject1">Attendance %</form:label>
					<div class="col-sm-2">
						<form:input class="form-control"
							path="percentageoaattendanceforsubject1" />
					</div>
				</div>
				<div class="form-group">

					<form:label class="col-sm-2 control-label" style="text-align:left"
						path="subject2">Subject 2</form:label>
					<div class="col-sm-2">
						<form:input class="form-control" path="subject2" />
					</div>
					<form:label class="col-sm-2 control-label" style="text-align:left"
						path="mark2">Marks</form:label>
					<div class="col-sm-2">
						<form:input class="form-control" path="mark2" />
					</div>

					<form:label class="col-sm-2 control-label" style="text-align:left"
						path="percentageoaattendanceforsubject2">Attendance %</form:label>
					<div class="col-sm-2">
						<form:input class="form-control"
							path="percentageoaattendanceforsubject2" />
					</div>
				</div>
				<div class="form-group">
					<form:label class="col-sm-2 control-label" style="text-align:left" path="subject3">Subject 3</form:label>
					<div class="col-sm-2">
						<form:input class="form-control" path="subject3" />
					</div>
					<form:label class="col-sm-2 control-label" style="text-align:left" path="mark3">Marks</form:label>
					<div class="col-sm-2">
						<form:input class="form-control" path="mark3" />
					</div>
					<form:label class="col-sm-2 control-label" style="text-align:left" path="percentageoaattendanceforsubject3">Attendance %</form:label>
					<div class="col-sm-2">
						<form:input class="form-control"
							path="percentageoaattendanceforsubject3" />
					</div>
				</div>
				<div class="form-group">
					<form:label class="col-sm-2 control-label" style="text-align:left" path="subject4">Subject 4</form:label>
					<div class="col-sm-2">
						<form:input class="form-control" path="subject4" />
					</div>
					<form:label path="mark4" class="col-sm-2 control-label" style="text-align:left" >Marks</form:label>
					<div class="col-sm-2">
						<form:input class="form-control" path="mark4" />
					</div>


					<form:label class="col-sm-2 control-label" style="text-align:left" path="percentageoaattendanceforsubject4">Attendance %</form:label>
					<div class="col-sm-2">
						<form:input class="form-control" path="percentageoaattendanceforsubject4" />
					</div>
				</div>
				<div class="form-group">
					<form:label class="col-sm-2 control-label" style="text-align:left" path="subject5">Subject 5</form:label>
					<div class="col-sm-2">
					<form:input class="form-control" path="subject5" />
					</div>
					<form:label class="col-sm-2 control-label" style="text-align:left" path="mark5">Marks</form:label>
					<div class="col-sm-2">
					<form:input class="form-control" path="mark5" />
					</div>
					<form:label class="col-sm-2 control-label" style="text-align:left" path="percentageoaattendanceforsubject5">Attendance %</form:label>
					<div class="col-sm-2">
					<form:input class="form-control" path="percentageoaattendanceforsubject5" />
					</div>
				</div>
				<div class="form-group">
					<form:label class="col-sm-2 control-label" style="text-align:left" path="subject6">Subject 6</form:label>
					<div class="col-sm-2">
					<form:input class="form-control" path="subject6" />
					</div>
					<form:label class="col-sm-2 control-label" style="text-align:left" path="mark6">Marks</form:label>
					<div class="col-sm-2">
					<form:input class="form-control" path="mark6" />
					</div>
					<form:label class="col-sm-2 control-label" style="text-align:left" path="percentageoaattendanceforsubject6">Attendance %</form:label>
					<div class="col-sm-2">
					<form:input class="form-control" path="percentageoaattendanceforsubject6" />
					</div>

				</div>
				<div class="form-group">
					<form:label class="col-sm-2 control-label" style="text-align:left" path="subject7">Subject 7</form:label>
					<div class="col-sm-2">
					<form:input class="form-control" path="subject7" />
					</div>
					<form:label class="col-sm-2 control-label" style="text-align:left" path="mark7">Marks</form:label>
					<div class="col-sm-2">
					<form:input class="form-control" path="mark7" />
					</div>
					<form:label class="col-sm-2 control-label" style="text-align:left" path="percentageoaattendanceforsubject7">Attendance %</form:label>
					<div class="col-sm-2">
					<form:input class="form-control" path="percentageoaattendanceforsubject7" />
					</div>
				</div>
				<div class="form-group">

					<form:label class="col-sm-2 control-label" style="text-align:left" path="subject8">Subject 8</form:label>
					<div class="col-sm-2">
					<form:input class="form-control" path="subject8" />
					</div>
					<form:label class="col-sm-2 control-label" style="text-align:left" path="mark8">Marks</form:label>
					<div class="col-sm-2">
					<form:input class="form-control"  path="mark8" />
					</div>
					<form:label class="col-sm-2 control-label" style="text-align:left" path="percentageoaattendanceforsubject8">Attendance %</form:label>
					<div class="col-sm-2">
					<form:input class="form-control"
						path="percentageoaattendanceforsubject8" />
					</div>	
				</div>

				<div class="form-group">
					<div class="col-sm-offset-2 col-sm-10">
						<input type="submit" class="btn btn-primary" value="Update" />
					</div>
				</div>

			</form:form>

</body>
</html>