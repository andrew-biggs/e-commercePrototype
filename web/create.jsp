<%--
  Created by IntelliJ IDEA.
  User: andre
  Date: 11/30/2018
  Time: 7:26 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Account Creation</title>
    <link rel="stylesheet" type="text/css" href="css/index.css">
</head>
<body>
<header>
    <h1>Welcome to Body Massage!</h1>
    <h2>Please Create a Account!</h2>
</header>

<form class="midd" action="blah" method="post">

    <input type="hidden" name="action" value="addUser">
    <label for="userN" >User name:</label>
    <input type="text" name="userN" id="userN" required><br>

    <label for="passU" >Password:</label>
    <input type="password" name="passU" id="passU" required><br>

    <label for="email" >Email:</label>
    <input type="email" name="email" id="email" required><br>

    <input type="submit" value="Create">

</form>
<a href="index.html">Home</a>
<a href="login.jsp">Login</a>
</body>
</html>
