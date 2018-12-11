<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" href="css/style.css">
    <link rel="stylesheet" href="css/header.css">
    <link rel="stylesheet" href="css/forms.css">
    <title>Transmission</title>
</head>
<body>

<%@include file="header.jsp"%>

<main>

    <%@include file="errormessage.jsp"%>

    <div class="formcontainer">
        <form method="POST" action="Controller?handler=user.login">

            <h2>Log in to the webshop</h2>
            <p><a href="Controller?handler=user.signup">or create a new account!</a></p>

            <input type="text" name="username" placeholder="Username">
            <input type="password" name="password" placeholder="Password">
            <input type="submit" value="Log in">

        </form>
    </div>

</main>

<footer>

</footer>

</body>
</html>