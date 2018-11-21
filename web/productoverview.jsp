<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1" />
<meta charset="UTF-8">
<title>Overview</title>
<link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
<div id="container">
    <%@include file="header.jsp"%>
    <main>
        <h2>Product overview</h2>
        <script>
            function getBaseUrl() {
                return window.location.origin + window.location.pathname;
            }

            function confirmDelete(productId) {
                if (confirm("Are you sure you want to delete the product?")) {
                    url = getBaseUrl() + '?action=deleteProduct&id=' + productId;
                    var xmlHttp = new XMLHttpRequest();
                    xmlHttp.onreadystatechange = setTimeout(function() {
                            window.location.href = getBaseUrl() +'?action=productOverview';
                        },500);
                    xmlHttp.open("GET", url, true); // true for asynchronous
                    xmlHttp.send(null);
                }
            }
            function addToCart(productId) {
                url = getBaseUrl() + '?action=addToCart&id=' + productId;
                var xmlHttp = new XMLHttpRequest();
                xmlHttp.open("GET", url, true); // true for asynchronous
                xmlHttp.send(null);
            }
        </script>
<table>
<tr>
<th>Name</th>
<th>Description</th>
<th>Price</th>
</tr>
<c:forEach items="${products}" var="product">
    <tr>
        <td><a href="Controller?action=modifyProduct&id=${product.id}"><c:out value="${product.name}" /></a></td>
        <td><c:out value="${product.description}" /></td>
        <td><c:out value="${product.price}" /></td>
        <td> <button onclick="addToCart(${product.id})">Add to cart</button> </td>
        <td> <button onclick="confirmDelete(${product.id})">Delete product</button> </td>
    </tr>
</c:forEach>

<caption>Products Overview</caption>
</table>
</main>
<footer>
&copy; Webontwikkeling 3, UC Leuven-Limburg
</footer>
</div>
</body>
</html>