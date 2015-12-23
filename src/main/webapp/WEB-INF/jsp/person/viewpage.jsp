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
            <li class="active"><a href="${home}">ವ್ಯಕಾತಿ</a></li>
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
        <h1>ವ್ಯಕಾತಿ</h1>

        <c:url var="saveUrl" value="/login/person/persons/add" />

        <form:form modelAttribute="personAttribute" method="POST"
                   action="${saveUrl}" class="form-horizontal" role="form">

            <div class="form-group">
                <label class="col-sm-2 control-label">ಹೆಸರು:</label>
                <div class="col-sm-6">
                    <form:input class="form-control " path="name" disabled="true" />
                </div>
            </div>
            <div class="form-group">
                <label class="col-sm-2 control-label">ಊರು :</label>
                <div class="col-sm-6">
                    <form:input class="form-control " path="place" disabled="true" />
                </div>
            </div>

            <div class="form-group">
                <label class="col-sm-2 control-label"> ಮೊಬೈಲ್  :</label>
                <div class="col-sm-6">
                    <form:input  class="form-control "  path="contact" disabled="true"  />
                </div>
            </div>
            <div class="form-group">
                <label class="col-sm-2 control-label"> ವಿಳಾಸ</label>
                <div class="col-sm-6">
                    <form:textarea rows="6" class="form-control " path="address" disabled="true" />
                </div>
            </div>
            <div class="form-group">
                <label class="col-sm-2 control-label" style="text-align: right"
                       path="whoishe">ಯಾರು  ಇವರು</label>
                <div class="col-sm-4">
                        <form:input  class="form-control "  path="whoishe" disabled="true"  />
                </div>
            </div>

        </form:form>

        <div class="padd">
            <c:url var="saveUrl" value="/login/uttara/uttaras/add" />
            <form:form modelAttribute="UttaraAttribute" method="POST"
                       action="${saveUrl}" class="form-horizontal" role="form">
                <div class="form-group">
                    <label class="col-sm-2 control-label">date </label>
                    <div class="col-sm-6">
                        <form:input class="form-control " path="uttaraDate"  />
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-2 control-label">matter</label>
                    <div class="col-sm-6">
                        <form:textarea rows="6" class="form-control " path="uttaraVishaya"  />
                    </div>
                </div>

                <div class="form-group">
                    <div class="col-sm-offset-2 col-sm-10">
                        <input class="btn btn-primary" type="submit" value="Save" />
                    </div>
                </div>
            </form:form>
        </div>

    </div>
</body>
</html>