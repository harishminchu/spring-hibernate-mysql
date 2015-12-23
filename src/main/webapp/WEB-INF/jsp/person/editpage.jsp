<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link href="<c:url value='/css/bootstrap.css' />" rel="stylesheet">
    <script src="<c:url value='/js/jquery.js'/>"></script>
    <script src="<c:url value='/js/bootstrap.min.js'/>"></script>
    <script src="<c:url value='/js/angular.js'/>"></script>
    <script type="text/javascript">
        angular.module('getUttara', []).controller('uttaraCtrl',
                [ '$scope', '$http', function ($scope, $http) {
                    $http.get('uttaraJson?id=${personAttribute.id}').success(function (uttarasList) {
                        $scope.uttaras = uttarasList;
                    });
                } ]);
    </script>

    <title>Insert title here</title>
</head>
<body>
<div class="container">
    <nav class="navbar navbar-default navbar-static-top" role="navigation">
        <ul class="nav navbar-nav">
            <c:url var="home" value="/login/person/persons"/>
            <li class="active"><a  tabindex="3" href="${home}">person</a></li>

            <c:url var="addUrl"
                   value="/login/person/persons/add"/>
            <li><a tabindex="4" class="btn btn-success" href="${addUrl}">Add person</a></li>
            <c:url var="logout" value="/login/UserLogin/login"/>
        </ul>
        <div class="widget-ead">
            <div class="pull-right">
                <a tabindex="11" href="${logout} "> Logout </a>
            </div>
            <div class="clearfix"></div>
        </div>

    </nav>

    <div class="widget-content">
        <div class="row">
            <h4>Person</h4>
            <c:url var="saveUrl" value="/login/person/persons/edit?id=${personAttribute.id}"/>

            <div class="form-control-static" >
                <form:form modelAttribute="personAttribute" method="POST"
                           action="${saveUrl}" class="form-horizontal" role="form">
                    <div class="form-group">
                       
                        <label class="col-sm-1 control-label">ಹೆಸರು:</label>

                        <div class="col-sm-2">
                            <form:input class="form-control " path="name"/>
                        </div>
                        <label class="col-sm-1 control-label">ಊರು :</label>

                        <div class="col-sm-2">
                            <form:input class="form-control " path="place"/>
                        </div>
                        
                        <label class="col-sm-1   control-label"> ಮೊಬೈಲ್ :</label>

                        <div class="col-sm-2">
                            <form:input type="text" class="form-control " path="contact"/>
                        </div>

        
                         <label class="col-sm-1 control-label" style="text-align: right"
                               path="photo"></label>

                        <div class="col-sm-2">

                            <img class="col-sm-9 img-circle" src="/asthana/login/person/persons/image?id=${personAttribute.id}" />

                        </div>
                
                        
                                                
                        
                        <label class="col-sm-1 control-label" style="text-align: right"
                               path="joinDate"> Join Date</label>

                        <div class="col-sm-2">

                            <form:input type="date" class="form-control" path="joinDate"/>

                        </div>

                        <label class="col-sm-1 control-label" style="text-align: right"
                               path="whoishe">ಯಾರು ಇವರು</label>

                        <div class="col-sm-2">
                            <form:select class="form-control" path="whoishe">
                                <form:option value="ಭಕ್ತ"></form:option>
                                <form:option value="ಸೇವಾಕರ್ತ"></form:option>
                            </form:select>

                        </div>
                        
                        <label class="col-sm-1 control-label"> ವಿಳಾಸ </label>

                        <div class="col-sm-2">
                            <form:textarea rows="3" class="form-control " path="address"/>
                        </div>
                
                                
                        
                        <div class="form-group">
                        <div class="col-sm-offset-2 col-sm-10">
                            <input class="btn btn-primary" type="submit" value="Save Person"/>
                        </div>
                    </div>

                </form:form>
            </div>


            <div ng-app="getUttara">
                <div ng-controller="uttaraCtrl">


                    
                    <div class="pull-left">
                        <div class="row-fluid">
                            <div class="fuelux" style="margin-top: 15px">
                                <table
                                        class="table table-bordered datagrid datagrid-stretch-header">
                                    <thead>
                                    <tr>
                                        <th colspan="4x">
                                            <c:url var="addUrl"
                                                   value="/login/uttara/add?id=${personAttribute.id}"/>

                                            <label>Search
                                            </label> <br> <input tabindex="1" type="text" ng-model="name"
                                                                 class="input-xlarge search-query"
                                                                 placeholder="Uttara  vishaya">

                                            <label>
                                            </label> <!-- <input type="text" ng-model="place"
                                                                 class="input-xlarge search-query" placeholder="Uttara Date"> -->

                                            <a tabindex="2" class="btn btn-primary" href="${addUrl}">Add Uttara</a>
                                    </tr>

                                    <tr>
                                        <th>Uttara vishaya</th>
                                        <th>Uttara Date</th>
                                        <th></th>
                                       <th></th>                                        <!--  <th width="1%"></th>
                                         <th width="1%"></th> -->
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <tr
                                            ng-repeat="u in uttaras | filter:name|filter:place |orderBy:'-uttaraDate'">
                                        <!-- <td><a href="{{project.uttaraVishaya}}" target="_blank">{{project.uttaraPlace}}</a></td> -->
                                        <td class="col-sm-10" >{{u.uttaraVishaya}}</td>
                                        <td>{{u.uttaraDate}}</td>
                                        <td>
                                            {{u.important}}
                                            <c:if test="${u.important}">
                                                <i class="glyphicon-bell"></i>
                                            </c:if>


                                        </td>
                                        <c:url var="updateUrl"
                                               value="/login/uttara/edit?id={{u.id}}"/>

                                        <td><a href="${updateUrl}"> EDIT<i class="glyphicon-ban-circle"></i></a>

                                            <!-- <td><a href="#/edit/{{project.$id}}"><i class="icon-p.encil"></i></a> -->
                                            <!-- <td><a href="${viewUrl}{{u.id}}">view</a></td> -->

                                        </td>
                                    </tr>

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