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

        <h2>Order history</h2>

        <table>
            <tr>
                <th>Order nr</th>
                <th>Date</th>
                <th>Title</th>
                <th>Artist</th>
                <th>Price</th>
                <th>Amount</th>
            </tr>
            <c:forEach items="${orders}" var="product">
                <tr>
                    <td><c:out value="${product.id}" /></td>
                    <td><c:out value="${product.date}" /></td>
                    <td><a href="Controller?handler=product.view&id=${product.id}"><c:out value="${product.title}" /></a></td>
                    <td><c:out value="${product.artist}" /></td>
                    <td><c:out value="${product.price}" /></td>
                    <td><c:out value="${product.amount}"/></td>
                </tr>
            </c:forEach>

        </table>

    </main>
    <footer>
    </footer>
</div>
</body>
</html>