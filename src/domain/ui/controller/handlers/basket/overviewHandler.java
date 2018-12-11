package domain.ui.controller.handlers.basket;

import domain.model.ShoppingCart;
import domain.ui.controller.RequestHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class overviewHandler extends RequestHandler {

    public String handleGet(HttpServletRequest request, HttpServletResponse response) {

        HttpSession session = request.getSession();
        ShoppingCart shoppingCart = (ShoppingCart) session.getAttribute("shoppingCart");

        if (shoppingCart != null && shoppingCart.nrOfItems() != 0) {
            request.setAttribute("cartItems", shoppingCart.getItems());

        } else {
            request.setAttribute("cartItems", null);
        }

        return "shoppingcart.jsp";
    }

}
