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
<div id="container">
    <%@include file="header.jsp"%>
    <main>

        <%@include file="errormessage.jsp"%>

        <h2>Product overview</h2>
        <script>
            function getBaseUrl() {
                return window.location.origin + window.location.pathname;
            }

            function confirmDelete(productId) {
                if (confirm("Are you sure you want to delete the product?")) {
                    url = getBaseUrl() + '?handler=product.delete&id=' + productId;
                    var xmlHttp = new XMLHttpRequest();
                    xmlHttp.onreadystatechange = setTimeout(function() {
                            window.location.href = getBaseUrl() +'?handler=product.overview';
                        },500);
                    xmlHttp.open("DELETE", url, true); // true for asynchronous
                    xmlHttp.send(null);
                }
            }
            function addToCart(productId) {
                url = getBaseUrl() + '?handler=basket.add&id=' + productId;
                var xmlHttp = new XMLHttpRequest();
                xmlHttp.open("POST", url, true); // true for asynchronous
                xmlHttp.send(null);
            }
        </script>
<table>
<tr>
<th>Title</th>
<th>Artist</th>
<th>Description</th>
<th>Genre</th>
<th>Type</th>
<th>Price</th>
<th></th>
<th></th>
</tr>
<c:forEach items="${products}" var="product">
    <tr>
        <td><a href="Controller?handler=product.modify&id=${product.id}"><c:out value="${product.title}" /></a></td>
        <td><c:out value="${product.artist}" /></td>
        <td><c:out value="${product.description}" /></td>
        <td><c:out value="${product.genre}" /></td>
        <td><c:out value="${product.type}" /></td>
        <td><c:out value="${product.price}" /></td>
        <td> <button onclick="addToCart(${product.id})">Add to cart</button> </td>
        <td> <button onclick="confirmDelete(${product.id})">Delete product</button> </td>
    </tr>
</c:forEach>

</table>
</main>
<footer>
</footer>
</div>
</body>
</html>