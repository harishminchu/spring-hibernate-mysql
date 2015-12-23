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
<script type=text/javascript" >




</script>




<title>Insert title here</title>
</head>
<body>

	<h1>ಉತ್ತರ</h1>

	<c:url var="saveUrl" value="/login/uttara/add?id=${uttaraAttribute.person.id}" />

	<form:form modelAttribute="uttaraAttribute" method="POST"
		action="${saveUrl}" class="form-horizontal" role="form">

		<div class="form-group">
			<label class="col-sm-2 control-label">ಉತ್ತರ ದಿನಾಂಕ :</label>
			<div class="col-sm-6">
				<form:input type="date" class="form-control " path="uttaraDate" />
			</div>
		</div>

		<div class="form-group">
			<label class="col-sm-2 control-label">ಉತ್ತರ ವಿಷ್ಯ :</label>
			<div class="col-sm-6">
				<form:textarea rows="6" class="form-control " path="uttaraVishaya" />
			</div>
		</div>


        <div class="form-group">
            <label class="col-sm-2 control-label">ಮುಖ್ಯ ವಿಷ್ಯ :</label>
            <div class="col-sm-2">
                <form:select  value="true"  class="form-control " path="important">
                    <form:option value="NO"  ></form:option>
                    <form:option value="YES"  ></form:option>
                </form:select>

            </div>
        </div>

        <div class="form-group">
			<div class="col-sm-offset-2 col-sm-10">
				<input type="submit" value="Save" />
			</div>
		</div>

	</form:form>

</body>
</html>