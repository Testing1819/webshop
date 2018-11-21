package domain.ui.controller.handlers;

import domain.model.CartItem;
import domain.model.Product;
import domain.model.ShoppingCart;
import domain.ui.controller.HandlerFactory;
import domain.ui.controller.RequestHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.*;

public class addToCartHandler extends RequestHandler {

    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
        if (request.getMethod().equals("GET")) {
            int productId = Integer.valueOf(request.getParameter("id"));

            HttpSession session = request.getSession();



            ShoppingCart shoppingCart = (ShoppingCart) session.getAttribute("shoppingCart");

            if (shoppingCart == null) {
                shoppingCart = new ShoppingCart();

            }

            shoppingCart.add(service.getProduct(productId), 1);

            session.setAttribute("shoppingCart", shoppingCart);
        }
        return HandlerFactory.getHandler("productOverview", service).handleRequest(request, response);
    }
}
