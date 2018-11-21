<header>
    <h1>
        <span>Web shop</span>
    </h1>
    <nav>
        <ul>
            <li id="${pageContext.request.requestURI eq '/index.jsp' ? 'actual' : ''}"><a href="Controller">Home</a></li>
            <li id="${pageContext.request.requestURI eq '/shoppingcart.jsp' ? 'actual' : ''}"><a href="Controller?action=shoppingCartView">Shopping Cart</a></li>
            <li id="${pageContext.request.requestURI eq '/personoverview.jsp' ? 'actual' : ''}"><a href="Controller?action=userOverview">Users</a></li>
            <li id="${pageContext.request.requestURI eq '/productoverview.jsp' ? 'actual' : ''}"><a href="Controller?action=productOverview">Products</a></li>
            <li id="${pageContext.request.requestURI eq '/productform.jsp' ? 'actual' : ''}"><a href="Controller?action=addProduct">Add product</a></li>
            <li id="${pageContext.request.requestURI eq '/signUp.jsp' ? 'actual' : ''}"><a href="Controller?action=signUp">Sign up</a></li>

        </ul>
    </nav>
</header>