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

        <h2>User overview</h2>
        <script>
            function getBaseUrl() {
                return window.location.origin + window.location.pathname;
            }

            function confirmDelete(userId) {
                if (confirm("Are you sure you want to delete the user?")) {
                    url = getBaseUrl() + '?handler=user.delete&id=' + userId;
                    var xmlHttp = new XMLHttpRequest();
                    xmlHttp.onreadystatechange = xmlHttp.onreadystatechange = setTimeout(function() {
                        window.location.href = getBaseUrl() + '?handler=user.overview';
                    },500);
                    xmlHttp.open("DELETE", url, true); // true for asynchronous
                    xmlHttp.send(null);
                }
            }
        </script>
<table>
<tr>
<th>Username</th>
<th>E-mail</th>
<th>First Name</th>
<th>Last Name</th>
    <th>Delete</th>
</tr>

<c:forEach items="${users}" var="user">
    <tr>
        <td><c:out value="${user.username}" /></td>
        <td><c:out value="${user.email}" /></td>
        <td><c:out value="${user.firstName}" /></td>
        <td><c:out value="${user.lastName}" /></td>
        <td> <button onclick="confirmDelete('${user.username}')">Delete user</button> </td>
    </tr>
</c:forEach>

</table>
</main>
<footer>
</footer>
</div>
</body>
</html>