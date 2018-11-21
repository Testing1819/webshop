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
        <h2>User overview</h2>
        <script>
            function getBaseUrl() {
                return window.location.origin + window.location.pathname;
            }

            function confirmDelete(userId) {
                if (confirm("Are you sure you want to delete the user?")) {
                    url = getBaseUrl() + '?action=deleteUser&id=' + userId;
                    var xmlHttp = new XMLHttpRequest();
                    xmlHttp.onreadystatechange = xmlHttp.onreadystatechange = setTimeout(function() {
                        window.location.href = getBaseUrl() + '?action=userOverview';
                    },500);
                    xmlHttp.open("GET", url, true); // true for asynchronous
                    xmlHttp.send(null);
                }
            }
        </script>
<table>
<tr>
<th>E-mail</th>
<th>First Name</th>
<th>Last Name</th>
    <th>Delete</th>
    <th>Check password</th>
</tr>
<c:forEach items="${users}" var="user">
    <tr>
        <td><c:out value="${user.email}" /></td>
        <td><c:out value="${user.firstName}" /></td>
        <td><c:out value="${user.lastName}" /></td>
        <td> <button onclick="confirmDelete('${user.id}')">Delete user</button> </td>
        <td><a href="Controller?action=checkPassword&user=${user.id}">Check</a></td>
    </tr>
</c:forEach>

<caption>Users Overview</caption>
</table>
</main>
<footer>
&copy; Webontwikkeling 3, UC Leuven-Limburg
</footer>
</div>
</body>
</html>