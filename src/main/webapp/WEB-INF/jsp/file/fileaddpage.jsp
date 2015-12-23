<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<h1>Create New file</h1>

<c:url var="saveUrl" value="/krams/file/files/add" />
<form:form modelAttribute="fileAttribute" method="POST" action="${saveUrl}">
	<table>
		<tr>
			<td><form:label path="firstName">First Name:</form:label></td>
			<td><form:input path="firstName"/></td>
		</tr>

		<tr>
			<td><form:label path="lastName">Last Name</form:label></td>
			<td><form:input path="lastName"/></td>
		</tr>
		
		<tr>
			<td><form:label path="person.personName">Person Name</form:label></td>
			<td><form:input path="person.personName"/></td>
		</tr>
		
		<tr>
			<td><form:label path="person.personContactNumber">Person Contact Number</form:label></td>
			<td><form:input path="person.personContactNumber"/></td>
		</tr>
		
		<tr>
			<td><form:label path="person.personAddress">address</form:label></td>
			<td><form:input path="person.personAddress"/></td>
		</tr>
		
		<tr>
			<td><form:label path="person.age">age</form:label></td>
			<td><form:input path="person.age"/></td>
		</tr>
		
		<tr>
			<td><form:label path="person.dateOfBirth">Date Of Birth </form:label></td>
			<td><form:input path="person.dateOfBirth"/></td>
		</tr>
		
		<tr>
			<td><form:label path="person.sex">sex</form:label></td>
			<td><form:select path="person.sex"/></td>
		</tr>
		
		
		
		
	</table>
	
	<input type="submit" value="Save" />
</form:form>

</body>
</html>