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
<h3><a href="/home?action=home">Back</a></h3>
<form method="post" action="?action=edit">
    <fieldset>
        <legend>Room Detail</legend>
        Mã phòng:<input type="text" name="txtRoomId" value="${requestScope.room.roomId}">
        <br>
        Trạng thái: <input type="text" name="txtState" value="${requestScope.room.state}">
        <br>
        First Name:<input type="text" name="txtFirstName" value="${requestScope.room.customer.firstName}">
        <br>
        Last Name:<input type="text" name="txtLastName" value="${requestScope.room.customer.lastName}">
        <br>
        Check in:<input type="date" name="dateCheckIn" value="${requestScope.room.dateOfRent}">
        <br>
        Check out:<input type="date" name="dateCheckOut" value="${requestScope.room.checkOutDate}">
        <br>
        CMT:<input type="text" name="CMT" value="${requestScope.room.customer.idCard}">
        <br>
        <input type="submit" value="Save">
    </fieldset>
</form>
</body>
</html>
