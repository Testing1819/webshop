<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<header>
    <div>
        <img src="img/logo.png" width="250px">
        <ul class="login">
            <c:if test="${empty user}">
                <li><a href="Controller?handler=user.login" id="account">Log in</a></li>
                <li><a href="Controller?handler=basket.overview" id="basket">Basket</a></li>
            </c:if>
            <c:if test="${user.role=='CUSTOMER' }">
                <li><a href="Controller?handler=user.login" id="account"><c:out value="${user.username}"/></a></li>
                <li><a href="Controller?handler=basket.overview" id="basket">Basket</a></li>
                <li><a href="Controller?handler=order.history" id="orderhistory">Order history</a></li>
            </c:if>
            <c:if test="${user.role=='ADMIN' }">
                <li><a href="Controller?handler=user.login" id="account"><c:out value="${user.username} (Admin)"/></a></li>
                <li><a href="Controller?handler=basket.overview" id="basket">Basket</a></li>
                <li><a href="Controller?handler=order.history" id="orderhistory">Order history</a></li>
            </c:if>
        </ul>
    </div>
    <nav>
        <ul>
            <li><a href="Controller?handler=home">Home</a></li>
            <li><a href="Controller?handler=product.catalogue">Catalogue</a></li>
            <c:if test="${user.role=='ADMIN' }">
                <li><a href="Controller?handler=product.overview">Manage products</a></li>
                <li><a href="Controller?handler=product.add">Add product</a></li>
                <li><a href="Controller?handler=user.overview">Manage users</a></li>

            </c:if>

        </ul>
    </nav>
</header>