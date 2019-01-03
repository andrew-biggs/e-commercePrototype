<%--
  Created by IntelliJ IDEA.
  User: andre
  Date: 11/30/2018
  Time: 7:41 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Main</title>
    <link rel="stylesheet" type="text/css" href="css/index.css">
</head>
<body>
<c:if test="${sessionScope.aUser == null}">
    <c:redirect url="index.html"></c:redirect>
</c:if>

<header>
    <h1>Welcome, <span>${aUser.userName}!</span> </h1>
       <h2> Please click an item to add it to your cart!</h2>
</header>

<table id = itemTable>
    <tr>
        <td>
            <form action="blah" method = "post">
                <p>
                    <img src = "pictures/hand.jpg" class="thumb"><br>
                    <label>Hand Massage</label><br>
                    <label> (Price: $9.50) </label><br>
                    <input type="hidden" name ="action" value="addService">
                    <input type="hidden" name="product_id" value="123">
                    <input type="hidden" name="itemDesc" value="Hand Massage">
                    <input type="hidden" name="numOfItems" value="1">
                    <input type="hidden" name="price" value="9.50">
                    <input type="submit" name="whatToDo" Value="Add">
                </p>
            </form>
        </td>
        <td>
            <form action="blah" method = "post">
                <p>
                    <img src = "pictures/body.jpg" class="thumb"><br>
                    <label>Body Massage</label><br>
                    <label> (Price: $12.50) </label><br>
                    <input type="hidden" name = "action" value="addService">
                    <input type="hidden" name="product_id" value="124">
                    <input type="hidden" name="itemDesc" value="Body Massage">
                    <input type="hidden" name="numOfItems" value="1">
                    <input type="hidden" name="price" value="12.50">
                    <input type="submit" name="whatToDo" Value="Add">
                </p>
            </form>
        </td>
    </tr>
    <tr>
        <td>
            <form action="blah" method = "post">
                <p>
                    <img src = "pictures/leg.jpg" class="thumb"><br>
                    <label>Leg Massage</label><br>
                    <label> (Price: $10:50) </label><br>
                    <input type="hidden" name = "action" value="addService">
                    <input type="hidden" name="product_id" value="125">
                    <input type="hidden" name="itemDesc" value="Leg Massage">
                    <input type="hidden" name="numOfItems" value="1">
                    <input type="hidden" name="price" value="10.50">
                    <input type="submit" name="whatToDo" value="Add">
                </p>
            </form>
        </td>
        <td>
            <form action="blah" method = "post">
                <p>
                    <img src = "pictures/foot.jpg" class="thumb"><br>
                    <label>Foot Massage</label><br>
                    <label> (Price: $2.50) </label><br>
                    <input type="hidden" name = "action" value="addService">
                    <input type="hidden" name="product_id" value="126">
                    <input type="hidden" name="itemDesc" value="Foot Massage">
                    <input type="hidden" name="numOfItems" value="1">
                    <input type="hidden" name="price" value="2.50">
                    <input type="submit" name="whatToDo" value="Add">
                </p>
            </form>
        </td>
    </tr>
    <tr>
        <td colspan="2"><p>
        </p>
            <form action="blah" method = "post">
                <input type="hidden" name="action" value="checkout">
                <input type="submit" name="whatToDo" value="Checkout">
            </form>
            <br><a href="index.html">Home</a>
        </td>
    </tr>
</table>

<div class = "midd">
    <label>Account Info:</label><br>
    <p> User Name: <span>${aUser.userName}</span></p>
    <p> Encrypted Password: <span>${aUser.userPassword}</span></p>
    <p> Email: <span>${aUser.email}</span></p>

</div>
</body>
</html>