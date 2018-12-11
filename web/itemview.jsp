<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" href="css/style.css">
    <link rel="stylesheet" href="css/header.css">
    <link rel="stylesheet" href="css/albumview.css">
    <title>Transmission</title>
</head>
<body>

<%@include file="header.jsp"%>


<main>

    <%@include file="errormessage.jsp"%>

    <script>
        function getBaseUrl() {
            return window.location.origin + window.location.pathname;
        }
        function addToCart(productId) {
            url = getBaseUrl() + '?handler=basket.add&id=' + productId;
            var xmlHttp = new XMLHttpRequest();
            xmlHttp.open("POST", url, true); // true for asynchronous
            xmlHttp.send(null);
        }
    </script>

    <div class="albumview">
        <a href="Controller?handler=product.view&id=${album.id}">
            <img src="img/album${album.id}.jpg"/>
        </a>
        <div>
            <a href="Controller?handler=product.view&id=${album.id}">
                <h2><c:out value="${album.artist}" /></h2>
            </a>
            <h3><c:out value="${album.title}" /></h3>
            <p><c:out value="${album.type}" /></p>
            <div class="buttons">
                <div class="button" onclick="addToCart(${album.id})">
                    <span class="type">Add to cart:</span>
                    <span class="price"><c:out value="€${album.price}" /></span>
                </div>
            </div>
        </div>
    </div>

</main>

<footer>

</footer>

</body>
</html>