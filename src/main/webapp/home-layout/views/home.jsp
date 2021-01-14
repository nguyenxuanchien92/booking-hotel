<%--
  Created by IntelliJ IDEA.
  User: nguye
  Date: 1/11/2021
  Time: 2:36 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Home</title>

    <meta charset="UTF-8">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
            integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
            crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
            integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
            crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
            integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
            crossorigin="anonymous"></script>

    <link rel="stylesheet" type="text/css" href="home-layout/css/home.css">
</head>
<body>
<div class="row" id="header">
    <img id="image-header" src="home-layout/images/beach.jpg">
</div>
<div id="content">
    <nav class="navbar navbar-expand-lg navbar-light bg-light">
        <a class="navbar-brand" href="#">Navbar</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav"
                aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarNav">
            <ul class="navbar-nav">

                <li class="nav-item active">
                    <a class="nav-link" href="/home?action=home">Home<span class="sr-only">(current)</span></a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/home?action=create">Create a room</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/home?action=price">Pricing</a>
                </li>

            </ul>
        </div>
    </nav>
























    <div class="content-container">
        <table border="1" align="center">
            <thead>
            <tr>
                <td>Room ID</td>
                <td>State</td>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${requestScope.roomList}" var="room">
                <tr>
                    <td>${room.roomId}</td>
                    <td>${room.state}</td>
                </tr>
            </c:forEach>
            <% request.removeAttribute("roomList"); %>
            </tbody>
        </table>
    </div>

</div>
<div id="bottom"></div>
</body>

</html>
