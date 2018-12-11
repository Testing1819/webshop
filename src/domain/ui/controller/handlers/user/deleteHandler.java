package domain.ui.controller.handlers.user;

import domain.model.Role;
import domain.ui.controller.RequestHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class deleteHandler extends RequestHandler {

    @Override
    public Role[] getAllowedRoles() {
        return new Role[]{Role.ADMIN};
    }

    @Override
    public String handleDelete(HttpServletRequest request, HttpServletResponse response) throws IOException {
            String username = request.getParameter("username");
            service.deleteUser(username);
            return forwardRequest("user.overview", request, response);
    }
}
