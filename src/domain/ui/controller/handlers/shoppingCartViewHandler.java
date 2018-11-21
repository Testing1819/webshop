package domain.ui.controller.handlers;

import domain.model.Product;
import domain.model.ShoppingCart;
import domain.ui.controller.RequestHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

public class shoppingCartViewHandler extends RequestHandler {
    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {

        HttpSession session = request.getSession();
        ShoppingCart shoppingCart = (ShoppingCart) session.getAttribute("shoppingCart");

        if (shoppingCart != null) {
            request.setAttribute("cartItems", shoppingCart.getItems());

        } else {
            request.setAttribute("cartItems", null);
        }

        return "shoppingcart.jsp";
    }
}
