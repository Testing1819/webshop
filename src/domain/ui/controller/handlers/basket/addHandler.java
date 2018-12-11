package domain.ui.controller.handlers.basket;

import domain.model.CartItem;
import domain.model.Product;
import domain.model.ShoppingCart;
import domain.ui.controller.HandlerFactory;
import domain.ui.controller.RequestHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.*;

public class addHandler extends RequestHandler {

    @Override
    public String handleGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        return null;
    }

    @Override
    public String handlePost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int productId = Integer.valueOf(request.getParameter("id"));

        HttpSession session = request.getSession();

        ShoppingCart shoppingCart = (ShoppingCart) session.getAttribute("shoppingCart");

        if (shoppingCart == null) {
            shoppingCart = new ShoppingCart();

        }

        shoppingCart.add(service.getProduct(productId), 1);

        session.setAttribute("shoppingCart", shoppingCart);
        return forwardRequest("product.overview", request, response);
    }

    @Override
    public String handleDelete(HttpServletRequest request, HttpServletResponse response) {
        return null;
    }
}
