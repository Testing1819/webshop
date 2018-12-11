<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1" />
<meta charset="UTF-8">
<title>Add product</title>
<link rel="stylesheet" href="css/style.css">
<link rel="stylesheet" href="css/header.css">
<link rel="stylesheet" href="css/forms.css">
</head>
<body>
<div id="container">

    <%@include file="header.jsp"%>

    <main>

        <%@include file="errormessage.jsp"%>

        <c:choose>
            <c:when test="${pageType eq 'CREATE'}">
                <h2>Add product</h2>
            </c:when>
            <c:when test="${pageType eq 'UPDATE'}">
                <h2>Update product</h2>
            </c:when>
        </c:choose>

        <c:choose>
            <c:when test="${pageType eq 'UPDATE'}">
                <c:set var="controllerUrl" value = "product.modify&id=${product.id}"/>
                <c:set var="buttonText" value = "Update product"/>
            </c:when>
            <c:when test="${pageType eq 'CREATE'}">
                <c:set var="controllerUrl" value = "product.add"/>
                <c:set var="buttonText" value = "Add product"/>
            </c:when>
        </c:choose>

        <form method="post" action="Controller?handler=${controllerUrl}" novalidate="novalidate">
            <!-- novalidate in order to be able to run tests correctly -->
            <input type="text" id="title" name="title" placeholder="Title" value="<c:out value="${product.title}" />">
            <input type="text" id="artist" name="artist" placeholder="Artist" value="<c:out value="${product.artist}" />">
            <input type="text" id="description" name="description" placeholder="Description" value="<c:out value="${product.description}" />">
            <input type="text" id="type" name="type" placeholder="Type" required value="<c:out value="${product.type}" />">
            <input type="text" id="genre" name="genre" placeholder="Genre" value="<c:out value="${product.genre}" />">
            <input type="text" id="price" name="price" placeholder="Price" value="<c:out value="${product.price}" />">
            <input type="submit" id="addProduct" value="${buttonText}">

        </form>
    </main>
<footer>
</footer>
</div>
</body>
</html>
