<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1" />
<meta charset="UTF-8">
<title>Sign Up</title>
<link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
<div id="container">

    <%@include file="header.jsp"%>

    <main>
        <c:choose>
            <c:when test="${pageType eq 'CREATE'}">
                <h2>Add product</h2>
            </c:when>
            <c:when test="${pageType eq 'UPDATE'}">
                <h2>Update product</h2>
            </c:when>
        </c:choose>


        <c:if test="${errors != null && !errors.isEmpty()}">
            <div class="alert-danger">
                <ul>
                <c:forEach items="${errors}" var="error">
                    <li>${error}</li>
                </c:forEach>
                </ul>
            </div>
        </c:if>

        <c:choose>
            <c:when test="${pageType eq 'UPDATE'}">
                <c:set var="controllerUrl" value = "modifyProduct&id=${product.productId}"/>
                <c:set var="buttonText" value = "Update product"/>
            </c:when>
            <c:when test="${pageType eq 'CREATE'}">
                <c:set var="controllerUrl" value = "addProduct"/>
                <c:set var="buttonText" value = "Add product"/>
            </c:when>
        </c:choose>

        <form method="post" action="Controller?action=${controllerUrl}" novalidate="novalidate">
            <!-- novalidate in order to be able to run tests correctly -->
            <p><label for="name">Name</label><input type="text" id="name" name="name"
             required value="<c:out value="${product.name}" />"> </p>
            <p><label for="description">Description</label><input type="text" id="description" name="description"
             required value="<c:out value="${product.description}" />"> </p>
            <p><label for="price">Price</label><input type="text" id="price" name="price"
             required value="<c:out value="${product.price}" />"> </p>
            <p><input type="submit" id="addProduct" value="${buttonText}"></p>

        </form>
    </main>
<footer>
&copy; Webontwikkeling 3, UC Leuven-Limburg
</footer>
</div>
</body>
</html>
