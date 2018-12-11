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

public class changeHandler extends RequestHandler {

    @Override
    public String handleGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int productId = Integer.valueOf(request.getParameter("id"));
        int amount = Integer.valueOf(request.getParameter("amount"));

        HttpSession session = request.getSession();

        ShoppingCart shoppingCart = (ShoppingCart) session.getAttribute("shoppingCart");

        if (shoppingCart == null) {
            shoppingCart = new ShoppingCart();

        }

        shoppingCart.change(productId, amount);

        session.setAttribute("shoppingCart", shoppingCart);
        return forwardRequest("basket.overview", request, response);
    }

}
