<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1" />
<meta charset="UTF-8">
<title>Sign Up</title>
<link rel="stylesheet" href="css/style.css">
<link rel="stylesheet" href="css/header.css">
<link rel="stylesheet" href="css/forms.css">
</head>
<body>
<div id="container">

    <%@include file="header.jsp"%>

    <main>

        <%@include file="errormessage.jsp"%>

        <div class="formcontainer">

            <form method="POST" action="Controller?handler=user.signup">
                <h2>Sign up</h2>
                <input type="text" id="username" name="username" required value="" placeholder="Username">
                <input type="text" id="firstName" name="firstName" required value="" placeholder="First name">
                <input type="text" id="lastName" name="lastName" required value="" placeholder="Last name">
                <input type="email" id="email" name="email" required value="" placeholder="E-mail">
                <input type="text" required value="" placeholder="Street (+nr)">
                <input type="text" required value="" placeholder="City">
                <input type="text" required value="" placeholder="Country">
                <input type="password" id="password"  name="password" placeholder="password" required>
                <input type="submit" id="signUp" value="Sign Up">

            </form>
        </div>
    </main>

<footer>
</footer>
</div>
</body>
</html>
