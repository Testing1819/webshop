<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <meta charset="UTF-8">
    <title>Overview</title>
    <link rel="stylesheet" href="css/style.css">
    <link rel="stylesheet" href="css/header.css">
    <link rel="stylesheet" href="css/table.css">
</head>
<body>

<%@include file="header.jsp"%>

<main>

    <%@include file="errormessage.jsp"%>

    <h2>Basket</h2>
    <script>
        var amount = document.getElementById("changeAmount").value;

        function getBaseUrl() {
            return window.location.origin + window.location.pathname;
        }

        function changeBasket(productId) {
                tempAmount = document.getElementById("changeAmount").value;

                if (tempAmount !== amount) {
                    amount = tempAmount;
                    var url = getBaseUrl() + '?handler=basket.change&id=' + productId + '&amount=' + amount;
                    var xmlHttp = new XMLHttpRequest();
                    xmlHttp.onreadystatechange = setTimeout(function() {
                        window.location.href = getBaseUrl() +'?handler=basket.overview';
                    },500);
                    xmlHttp.open("GET", url, true); // true for asynchronous
                    xmlHttp.send(null);
                }
        }

        function confirmDelete(productId) {
            if (confirm("Are you sure you want to delete the product from yout basket?")) {
                url = getBaseUrl() + '?handler=basket.delete&id=' + productId;
                var xmlHttp = new XMLHttpRequest();
                xmlHttp.onreadystatechange = xmlHttp.onreadystatechange = setTimeout(function() {
                    window.location.href = getBaseUrl() + '?handler=basket.overview';
                },500);
                xmlHttp.open("DELETE", url, true); // true for asynchronous
                xmlHttp.send(null);
            }
        }
    </script>

    <c:choose>
        <c:when test="${not empty cartItems}">
            <table>
                <tr>
                    <th>Title</th>
                    <th>Artist</th>
                    <th>Price</th>
                    <th>Amount</th>
                    <th></th>
                </tr>
                <c:forEach items="${cartItems}" var="product">
                    <tr>
                        <td><a href="Controller?handler=product.view&id=${product.id}"><c:out value="${product.title}" /></a></td>
                        <td><c:out value="${product.artist}" /></td>
                        <td><c:out value="${product.price}" /></td>
                        <td><input onchange="changeBasket(${product.id})" type="number" id="changeAmount" min="0" max="100" value="<c:out value="${product.amount}"/>"></td>
                        <td> <button onclick="confirmDelete('${product.id}')">Delete product</button> </td>
                    </tr>
                </c:forEach>

            </table>
            <form class="orderform" method="POST" action="Controller?handler=basket.order">
                <input type="submit" value="Place your order" />
            </form>
        </c:when>
        <c:otherwise>
            <table>
                <tr>
                    <th>Your shopping cart is empty.</th>
                </tr>
            </table>
        </c:otherwise>
    </c:choose>


</main>
<footer>
</footer>

</body>
</html>