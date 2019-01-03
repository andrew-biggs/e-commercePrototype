<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>Cart Page</title>
    <link rel="stylesheet" type="text/css" href="css/index.css">
</head>
<body>
<c:if test="${sessionScope.aUser == null}">
    <c:redirect url="index.html"></c:redirect>
</c:if>
<table id="cartTable">
    <th>Product Description</th>
    <c:set var = "total" value="${0}"></c:set>

    <c:forEach var="prod" items="${aCart.myCart}">
        <tr>
            <td><c:out value="${prod.itemDescription}"></c:out></td>
        </tr>
    </c:forEach>
    <tr><td colspan="5">
        <form action="blah" method="post">
            <input type="hidden" name="action" value="continue">
            <input type="submit" name="whatToDo" value="Continue Shopping">
        </form>
    </td></tr>
    <tr><td colspan="5">
        <form action="blah" method="post">
            <input type="hidden" name="action" value="checkout">
            <input type="submit" name="whatToDo" value="Checkout">
        </form>
    </td></tr>

</table>
</body>
</html>

