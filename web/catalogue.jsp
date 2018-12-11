<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <meta charset="UTF-8">
    <title>Overview</title>
    <link rel="stylesheet" href="css/style.css">
    <link rel="stylesheet" href="css/header.css">
    <link rel="stylesheet" href="css/list.css">
</head>
<body>
<div id="container">
    <%@include file="header.jsp"%>
    <main>
        <%@include file="errormessage.jsp"%>

        <%@include file="succeededmessage.jsp"%>

        <h2>Vinyl catalogue</h2>
        <script>
            function getBaseUrl() {
                return window.location.origin + window.location.pathname;
            }
            function addToCart(productId) {
                document.getElementById("succeeded").style.display = "block";
                url = getBaseUrl() + '?handler=basket.add&id=' + productId;
                var xmlHttp = new XMLHttpRequest();
                xmlHttp.open("POST", url, true); // true for asynchronous
                xmlHttp.send(null);
            }
        </script>

        <div class="albumlist">

            <c:forEach items="${products}" var="product">
                <div class="album_wide">

                    <a href="Controller?handler=product.view&id=${product.id}">
                        <img src="img/album${product.id}.jpg"/>
                    </a>

                    <div>
                        <h3><a href="Controller?handler=product.view&id=${product.id}"><c:out value="${product.artist}" /></a></h3>
                        <h4><c:out value="${product.title}" /></h4>

                        <div class="buttons">
                            <div class="button" onclick="addToCart(${product.id})">
                                <span class="type">Add to cart:</span>
                                <span class="price"><c:out value="€${product.price}" /></span>
                            </div>
                        </div>
                    </div>

                    <p><c:out value="${product.type}" /></p>
                </div>
            </c:forEach>

        </div>

    </main>
    <footer>
    </footer>
</div>
</body>
</html>