package domain.ui.controller.handlers.user;

import domain.model.Role;
import domain.model.User;
import domain.ui.controller.RequestHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class overviewHandler extends RequestHandler {

    @Override
    public Role[] getAllowedRoles() {
        return new Role[]{Role.ADMIN};
    }

    public String handleGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        List<User> users = service.getUsers();
        request.setAttribute("users", users);
        return "personoverview.jsp";
    }
}
