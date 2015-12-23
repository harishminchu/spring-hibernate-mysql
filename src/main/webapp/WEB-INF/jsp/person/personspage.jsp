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
    <script type="text/javascript">
        angular.module('getPerson', []).controller('personCtrl',
                [ '$scope', '$http', function ($scope, $http) {
                    $http.get('personJson').success(function (personsList) {
                        $scope.persons = personsList;
                        console.log(personsList);
                    });
                } ]);
    </script>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link href="<c:url value='/css/bootstrap.css' />" rel="stylesheet">
    <script src="<c:url value='/js/jquery.js'/>"></script>
    <script src="<c:url value='/js/bootstrap.min.js'/>"></script>
    <script src="<c:url value='/js/angular.js'/>"></script>
    <title>Insert title here</title>
</head>
<body ng-app="getPerson">
<div class="container">
    <nav class="navbar navbar-default navbar-static-top" role="navigation">
        <ul class="nav navbar-nav">
            <c:url var="home" value="/login/person/persons/"/>
            <c:url var="logout" value="/login/UserLogin/login"/>
            <li class="active"><a href="${home}">person</li>
        </ul>
        <div class="widget-head">
            <div class="pull-right">
                <a  href="${logout} ">
                    Logout
                </a>
            </div>
            <div class="clearfix"></div>
        </div>
    </nav>
    <div class="widget">
        <div class="widget-head">
            <div class="pull-left">person</div>
            <div class="clearfix"></div>
        </div>

        <div ng-controller="personCtrl">
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
                                               value="/login/person/persons/add"/>

                                            <label>Search
                                        </label> <br> <input tabindex="1" type="text" ng-model="name"
                                                             class="input-xlarge search-query" placeholder="Name">

                                            <label>
                                            </label>  <input tabindex="7" type="text" ng-model="place"
                                                                 class="input-xlarge search-query" placeholder="Place">

                                            <a tabindex="2"  class="btn btn-primary" href="${addUrl}">Add</a>
                                </tr>

                              <tr>
                                    <th>Person Name</th>
                                    <th>Place</th>
                                   <!-- <th>photo</th> -->
                                   <!--  <th width="1%"></th>
                                    <th width="1%"></th> -->
                                </tr>
                                </thead>
                                <tbody>
                                <tr
                                        ng-repeat="u in persons | filter:name|filter:place |orderBy:'name'">
                                    <!-- <td><a href="{{project.personVishaya}}" target="_blank">{{project.personPlace}}</a></td> -->
                                    <c:url var="updateUrl"
                                           value="/login/person/persons/edit?id={{u.id}}"/>

                                    <c:url
                                            var="viewUttaraUrl" value="/login/uttara/view?id={{u.id}}"/>
                                    <c:url
                                            var="addUttaraUrl" value="/login/uttara/add?id={{u.id}}"/>

                                    <td>
                                        <a tabindex="3" href="${updateUrl}">
                                            {{u.name}}
                                        </a>
                                       </td>
                                    <td>{{u.place}}</td>
                                    <!--<td> <img class="col-sm-6 img-circle" src="/asthana/login/person/persons/image?id={{u.id}}"></td> -->
                                   
                                 <!--   <td><a href="${viewUttaraUrl}">view uttara</a></td>
                                    <td><a href="${addUttaraUrl}">add uttara </a></td> -->
                                    <!-- <td><a href="#/edit/{{project.$id}}"><i class="icon-pencil"></i></a> -->
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



</div>

</body>
</html>