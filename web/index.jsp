<!DOCTYPE html>
<html lang="en">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<meta http-equiv="X-UA-Compatible" content="ie=edge">
	<link rel="stylesheet" href="css/style.css">
	<link rel="stylesheet" href="css/header.css">
	<title>Transmission</title>
</head>
<body>

<%@include file="header.jsp"%>


<main>

    <%@include file="errormessage.jsp"%>

	<div class="banner">

		<c:forEach items="${albums}" var="album">
			<div class="slide">
				<a href="Controller?handler=product.view&id=${album.id}">
					<img src="img/album${album.id}.jpg"/>
				</a>
				<div>
					<a href="Controller?handler=product.view&id=${album.id}">
						<h2><c:out value="${album.artist}" /></h2>
					</a>
					<h3><c:out value="${album.title}" /></h3>
					<p><c:out value="${album.type}" /></p>
				</div>
			</div>
		</c:forEach>


		<div class="pointer_left" onclick="plusDivs(-1)">&#10094;</div>
		<div class="pointer_right" onclick="plusDivs(1)">&#10095;</div>
	</div>


	<h2>Popular items</h2>
	<div class="album_grid">
		<c:forEach items="${albums}" var="album">
			<a href="Controller?handler=product.view&id=${album.id}">
				<div class="album">
					<div class="flip_card">
						<div class="front_side">
							<img src="img/album${album.id}.jpg"/>
						</div>
						<div class="back_side">
							<span class="album_data"><span class="album_artist"><c:out value="${album.artist}" /></span><hr><c:out value="${album.title}" /></span>
							<span class="album_price">&euro; <c:out value="${album.price}" /></span>
							<span class="item_type"><c:out value="${album.description}" /></span>
						</div>
					</div>
				</div>
			</a>
		</c:forEach>

	</div>


</main>

<footer>

</footer>

<script>
    var slideIndex = 1;
    carousel();

    function plusDivs(n) {
        showDivs(slideIndex += n);
    }

    function currentDiv(n) {
        showDivs(slideIndex = n);
    }

    function showDivs(n) {
        var i;
        var x = document.getElementsByClassName("slide");
        var dots = document.getElementsByClassName("demo");
        if (n > x.length) {slideIndex = 1}
        if (n < 1) {slideIndex = x.length}
        for (i = 0; i < x.length; i++) {
            x[i].style.display = "none";
        }
        x[slideIndex-1].style.display = "block";
    }

    function carousel() {
        plusDivs(1);
        setTimeout(carousel, 10000); // Change image every 10 seconds
    }
</script>

</body>
</html>