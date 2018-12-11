package domain.ui.controller.handlers.order;

import domain.model.Order;
import domain.model.Role;
import domain.model.User;
import domain.ui.controller.RequestHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

public class historyHandler extends RequestHandler {

    @Override
    public Role[] getAllowedRoles() {
        return new Role[]{Role.ADMIN, Role.CUSTOMER};
    }

    public String handleGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        List<Order> orders = service.getOrdersFromUser(user.getUsername());
        request.setAttribute("orders", orders);
        return "orderhistory.jsp";
    }

}