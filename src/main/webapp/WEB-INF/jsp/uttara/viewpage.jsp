<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link href="<c:url value='/css/bootstrap.css' />" rel="stylesheet">
    <!-- Custom styles for this template -->
    <link href="<c:url value='/css/jumbotron.css' />" rel="stylesheet">

    <title>Insert title here</title>
    <script src="<c:url value='/js/angular.js'/>"></script>
   <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link href="<c:url value='/css/bootstrap.css' />" rel="stylesheet">
    <script src="<c:url value='/js/jquery.js'/>"></script>
    <script src="<c:url value='/js/bootstrap.min.js'/>"></script>
    <script src="<c:url value='/js/angular.js'/>"></script>
    <title>Insert title here</title>
    <script type="text/javascript">
        angular.module('getUttara', []).controller('uttaraCtrl',
                [ '$scope', '$http', function ($scope, $http) {
                    $http.get('uttaraJson?id=${id}').success(function (uttarasList) {
                        $scope.uttaras = uttarasList;
                    });
                } ]);
    </script>

</head>
<body ng-app="getUttara">
<div class="container">
    <nav class="navbar navbar-default navbar-static-top" role="navigation">
        <ul class="nav navbar-nav">
            <c:url var="home" value="/login/uttara/uttaras/"/>
            <c:url var="logout" value="/login/UserLogin/login"/>
            <li class="active"><a href="${home}">uttara</li>
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
    <div class="widget">
        <div class="widget-head">
            <div class="pull-left">uttara</div>
            <div class="clearfix"></div>
        </div>

        <div ng-controller="uttaraCtrl">
            <div class="widget-content">
                <div class="padd">
                    <div class="row-fluid">
                        <div class="fuelux" style="margin-top: 15px">
                            <table
                                    class="table table-bordered datagrid datagrid-stretch-header">
                                <thead>
                                <tr>
                                    <th colspan="7">
                                        <c:url var="addUrl"
                                               value="/login/uttara/add?id=${id}"/>

                                        <label>Search
                                        </label> <br> <input type="text" ng-model="name"
                                                             class="input-xlarge search-query" placeholder="Uttara  vishaya">

                                        <label>
                                        </label>  <input type="text" ng-model="place"
                                                         class="input-xlarge search-query" placeholder="Uttara Date">

                                        <a class="btn btn-primary" href="${addUrl}">Add</a>
                                </tr>

                                <tr>
                                    <th>Uttara vishaya</th>
                                    <th>Uttara Date</th>
                                    <th></th>
                                    <th></th>
                                    <!--  <th width="1%"></th>
                                     <th width="1%"></th> -->
                                </tr>
                                </thead>
                                <tbody>
                                <tr
                                        ng-repeat="u in uttaras | filter:name|filter:place |orderBy:'-uttaraDate'">
                                    <!-- <td><a href="{{project.uttaraVishaya}}" target="_blank">{{project.uttaraPlace}}</a></td> -->
                                    <td>{{u.uttaraVishaya}}</td>
                                    <td>{{u.uttaraDate}}</td>


                                    <td><a href="#/edit/${id}"><i class="icon-pencil"></i></a>
                                    <!-- <td><a href="${viewUrl}{{u.id}}">view</a></td> -->

                                    </td>
                                </tr>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <!--<table class="table table-bordered table-striped table-condensed">
		<thead>
			<tr>
				<th>ಉತ್ತರ ವಿಷಯ</th>
				<th>ಉತ್ತರ ದಿನಾಂಕ</th>
				<th>ಹೆಸರು</th>
				<th>ಊರು</th>
				<th colspan="3"></th>
			</tr>
		</thead>
		<tbody>

	</table> -->

    <%-- 	<c:if test="${empty uttaras}">
There are currently no uttaras in the list. <a href="${addUrl}">Add</a> a uttara.
</c:if>
 --%>


</div>

</body>
</html>