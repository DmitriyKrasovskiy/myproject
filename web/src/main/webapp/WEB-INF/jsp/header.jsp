<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!doctype html>
<html lang="en">
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

    <title>Devices</title>
  </head>
  <body>
   <nav class="navbar navbar-expand-lg navbar-light bg-light">
      <a class="navbar-brand" href="${pageContext.request.contextPath}/">Our devices</a>
      <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
      </button>

    <div class="collapse navbar-collapse" id="navbarSupportedContent">
      <ul class="navbar-nav mr-auto">
      <li class="nav-item active">
                <a class="nav-link" href="${pageContext.request.contextPath}/home">Home page <span class="sr-only">(current)</span></a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="${pageContext.request.contextPath}/deviceList">Device List Page</a>
        </li>

<sec:authorize access="!isAuthenticated()">
        <li class="nav-item">
          <a class="nav-link" href="${pageContext.request.contextPath}/register" >Register</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="${pageContext.request.contextPath}/login" >Login</a>
        </li>
        <li class="nav-item">
</sec:authorize>
<sec:authorize access="isAuthenticated()">
          <a class="nav-link" href="${pageContext.request.contextPath}/logout" >Logout</a>
        </li>
</sec:authorize>
      </ul>
      <form action="${pageContext.request.contextPath}/search" class="form-inline my-2 my-lg-0">
        <input name ="searchStr" class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search">
        <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
      </form>
    </div>
  </nav>