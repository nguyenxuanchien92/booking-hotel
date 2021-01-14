<%--
  Created by IntelliJ IDEA.
  User: nguye
  Date: 1/14/2021
  Time: 12:51 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<form method="post" action="/home">
    <fieldset>
        <legend>Room Detail</legend>
        <input type="text" name="txtRoomId" value="${requestScope.room.roomId}">
        <br>
        <input type="text" name="txtState" value="${requestScope.room.state}">
        <br>
        <input type="text" name="txtFirstName" value="${requestScope.room.person.firstName}">
        <br>
        <input type="text" name="txtLastName" value="${requestScope.room.person.lastName}">
        <br>
        <input type="date" name="dateCheckIn" value="${requestScope.room.dateOfRent}">
        <br>
        <input type="date" name="dateCheckOut" value="${requestScope.room.checkOutDate}">
        <br>
        <input type="submit" value="Save">
    </fieldset>
</form>
</body>
</html>
