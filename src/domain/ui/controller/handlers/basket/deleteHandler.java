package domain.ui.controller.handlers.basket;

import domain.model.Role;
import domain.model.ShoppingCart;
import domain.ui.controller.RequestHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class deleteHandler extends RequestHandler {

    public String handleDelete(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int productId = Integer.valueOf(request.getParameter("id"));

        HttpSession session = request.getSession();
        ShoppingCart shoppingCart = (ShoppingCart) session.getAttribute("shoppingCart");
        shoppingCart.remove(productId);
        return forwardRequest("basket.overview", request, response);
    }

}
