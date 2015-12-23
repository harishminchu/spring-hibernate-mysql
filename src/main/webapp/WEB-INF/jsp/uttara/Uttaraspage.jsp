<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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

    <title>Insert title here</title>
    <script type="text/javascript">
        angular.module('getUttar', []).controller('uttaraCtrl',
                [ '$scope', '$http', function($scope, $http) {
                    $http.get('uttaraJson').success(function(uttarasList) {
                        $scope.uttaras = uttarasList;
                    });
                } ]);
    </script>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link href="<c:url value='/css/bootstrap.css' />" rel="stylesheet">
    <script src="<c:url value='/js/jquery.js'/>"></script>
    <script src="<c:url value='/js/bootstrap.min.js'/>"></script>

    <title>Insert title here</title>
</head>
<body ng-app="getUttar">
<div class="container">
    <nav class="navbar navbar-default navbar-static-top" role="navigation">
        <ul class="nav navbar-nav">
            <c:url var="home" value="/login/uttara/uttaras/" />
            <c:url var="logout" value="/login/UserLogin/login" />
            <li class="active"><a href="${home}">Proctor</a></li>
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
            <div class="pull-left">Proctor</div>
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
                                    <th colspan="7"><c:url var="addUrl"
                                                           value="/login/uttara/uttaras/add" /> <c:url
                                            var="editUrl" value="/login/uttara/uttaras/edit?id=" />
                                        <c:url var="deleteUrl"
                                               value="/login/uttara/uttaras/delete?id=" /> <label>Search
                                        </label> <br> <input type="text" ng-model="search"
                                                             class="input-xlarge search-query" placeholder="Name">
                                        <a class="btn btn-primary" href="${addUrl}">Add</a>
                                </tr>

                                <tr>
                                    <th>ಉತ್ತರ ಡೇಟ್ </th>
                                    <th>ಉತ್ತರ ವಿಷಯ</th>
                                    <th>Contact</th>
                                    <th width="1%"></th>
                                    <th width="1%"></th>
                                </tr>
                                </thead>
                                <tbody>
                                <tr
                                        ng-repeat="u in uttaras | filter:search | orderBy:'name'">
                                    <!-- <td><a href="{{project.uttaraVishaya}}" target="_blank">{{project.personPlace}}</a></td> -->
                                    <td>{{u.name}}</td>
                                    <td>{{u.email}}</td>
                                    <td>{{u.contact}}</td>
                                    <!-- <td><a href="#/edit/{{project.$id}}"><i class="icon-pencil"></i></a> -->
                                    <td><a href="${editUrl}{{u.id}}">Edit</a></td>
                                    <td><a href="${deleteUrl}{{u.id}}">Delete</a></td>
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

			<c:forEach items="${uttaras}" var="uttara">
				<c:url var="editUrl"
					value="/login/uttara/uttaras/edit?id=${uttara.id}" />
				<c:url var="deleteUrl"
					value="/login/uttara/uttaras/delete?id=${uttara.id}" />
				<tr>
					<td><c:out value="${uttara.uttaraVishaya}" /></td>
					<td><c:out value="${uttara.uttaraSamaya}" /></td>
					<td><c:out value="${uttara.personName}" /></td>
					<td><c:out value="${uttara.personPlace}" /></td>
					<td><a href="${editUrl}">Edit</a></td>
					<td><a href="${deleteUrl}">Delete</a></td>
					<td><a href="${addUrl}">Add</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table> -->

    <%-- 	<c:if test="${empty uttaras}">
There are currently no uttaras in the list. <a href="${addUrl}">Add</a> a uttara.
</c:if>
 --%>



</div>

</body>
</html>