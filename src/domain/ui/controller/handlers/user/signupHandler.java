package domain.ui.controller.handlers.user;

import domain.model.Role;
import domain.model.User;
import domain.ui.controller.RequestHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class signupHandler extends RequestHandler {

    public String handleGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        return "signup.jsp";
    }

    public String handlePost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        List<String> attributes = Arrays.asList("username", "firstName", "lastName", "email");
        User user = new User();

        List<String> errors = createInstanceFromParameters(attributes, request, user);
        user.setRole(Role.CUSTOMER);

        try {
            user.setUnhashedPassword(request.getParameter("password"));
        } catch (IllegalArgumentException e) {
            errors.add(e.getMessage());
        }

        if (errors.isEmpty() && service.containsUser(user.getUsername())) {
            errors.add("Username is already taken");
        }

        if (errors.isEmpty()) {
            service.addUser(user);

            return forwardRequest("home", request, response);
        } else {
            request.setAttribute("errors", errors);
            return "signup.jsp";
        }
    }

}
