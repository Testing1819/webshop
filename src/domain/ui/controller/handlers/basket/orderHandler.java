package domain.ui.controller.handlers.basket;

import domain.model.*;
import domain.ui.controller.HandlerFactory;
import domain.ui.controller.RequestHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.*;

public class orderHandler extends RequestHandler {

    @Override
    public String handlePost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession();

        ShoppingCart shoppingCart = (ShoppingCart) session.getAttribute("shoppingCart");
        User user = (User) session.getAttribute("user");

        if (shoppingCart != null) {
            for (CartItem item: shoppingCart.getItems()) {
                Order order = new Order(service.getNrOfOrders(), user.getUsername(), item.getTitle(), item.getArtist(), item.getPrice(), item.getAmount());
                service.addOrder(order);
            }
        }

        session.removeAttribute("shoppingCart");
        return forwardRequest("order.history", request, response);
    }
}
