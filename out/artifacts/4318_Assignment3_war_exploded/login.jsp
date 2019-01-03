<%--
  Created by IntelliJ IDEA.
  User: andre
  Date: 11/30/2018
  Time: 7:25 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>User Login</title>
    <link rel="stylesheet" type="text/css" href="css/index.css">
</head>
<body>
<header>
    <h1>Welcome to Body Massage!</h1>
    <h2>Please Login!</h2>
</header>
<p> <%
    String error = (String) request.getAttribute("error");
    if (error == null){
        out.println("");
    }
    else {
        out.println(error);
    }
%></p><br>

<form class= "midd" action="blah" method="post">


    <input type="hidden" name="action" value="enter">
    <label for="userN" >User name:</label>
    <input type="text" name="userN" id="userN"><br>

    <label for="passU" >Password:</label>
    <input type="password" name="passU" id="passU"><br>

    <label for="email" >Email:</label>
    <input type="email" name="email" id="email"><br>

    <input type="submit" value="Login"><br><br>

    <a href="index.html">Home</a>

</form>
</body>
</html>
