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
    <th>Product Id</th>
    <th>Product Description</th>
    <th>Product Price</th>
    <c:set var = "total" value="${0}"></c:set>

    <c:forEach var="prod" items="${aCart.myCart}">
        <tr>
            <td><c:out value="${prod.itemId}"></c:out></td>
            <td><c:out value="${prod.itemDescription}"></c:out></td>
            <td><c:out value="${prod.price}"></c:out></td>
            <c:set var="total" value="${total + prod.numOfItems * prod.price }"></c:set>
        </tr>
    </c:forEach>

    <tr><td colspan="5">Total Price: $<fmt:formatNumber type="number" minFractionDigits="2">
        <c:out value="${total}"></c:out></fmt:formatNumber> </td></tr>

    <tr><td colspan="5">
        <form action="blah" method="post">
            <input type="hidden" name="action" value="continue">
            <input type="submit" name="whatToDo" value="Continue Shopping">
        </form>
    </td></tr>
    <tr><td colspan="5">
        <form action="blah" method="get">
            <input type="hidden" name="action" value="logout">
            <input type="submit" name="whatToDo" value="Logout">
        </form>
    </td></tr>

</table>
</body>
</html>
