<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <title>Home</title>
    <link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
<div id="container">
    <%@include file="header.jsp"%>
    <h2>Check password</h2>
    <main>
        <c:if test = "${not empty user}">
            <p>Fill out your password:</p>
            <form method="post" action="Controller?action=checkPassword" novalidate="novalidate">
                <input type="hidden" id="userId" name="userId"
                                                             required value="${user.userId}">
                <p><label for="password">Password</label><input type="text" id="password" name="password"
                                                                required value=""> </p>
                <p><input type="submit" id="check" value="Check"></p>
            </form>
        </c:if>
        <c:if test = "${passwordCheck eq true}">
            <p>The password is correct!</p>
        </c:if>
        <c:if test = "${passwordCheck eq false}">
            <p>The password is NOT correct.</p>
        </c:if>

    </main>
    <footer> &copy; Webontwikkeling 3, UC Leuven-Limburg </footer>
</div>
</body>
</html>