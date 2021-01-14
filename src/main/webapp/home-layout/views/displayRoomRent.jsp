<%--
  Created by IntelliJ IDEA.
  User: nguye
  Date: 1/13/2021
  Time: 3:45 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title></title>
</head>
<body>
<div class="content-container">
    <h3><a href="/home">Back</a></h3>
    <form>
        <div id="search" align="center">
            <input type="hidden" name="action" value="search">
            <input type="text" name="searchTxt">
            <input type="submit" value="search">
        </div>
    </form>
    <br>
    <table border="1" align="center">
        <thead>
        <tr>
            <td>Room ID</td>
            <td>State</td>
            <td>First Name</td>
            <td>Last Name</td>
            <td>Check in</td>
            <td>Check out</td>
            <td colspan="2" style="text-align: center">Option</td>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${requestScope.roomRents}" var="room">
            <tr>
                <td>${room.roomId}</td>
                <td>${room.state}</td>
                <td>${room.person.firstName}</td>
                <td>${room.person.lastName}</td>
                <td>${room.dateOfRent}</td>
                <td>${room.checkOutDate}</td>
                <td>
                    <form method="post" action="?action=edit&id=${room.roomId}">
                        <input type="submit" value="edit">
                    </form>
                    <form method="post" action="?action=delete&id=${room.roomId}">
                        <input type="submit" value="delete">
                    </form>
                </td>

            </tr>
        </c:forEach>
        <% request.removeAttribute("roomRents"); %>
        </tbody>
    </table>
</div>
</body>
</html>
