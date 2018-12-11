package domain.ui.controller.handlers.user;

import domain.model.User;
import domain.ui.controller.RequestHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

public class loginHandler extends RequestHandler {

    @Override
    public String handleGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        return "login.jsp";
    }

    @Override
    public String handlePost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        ArrayList<String> errors = new ArrayList<>();

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        if (username == null || username.equals("")) {
            errors.add("Please fill in your username");
        }

        if (password == null || password.equals("")) {
            errors.add("Please fill in your password");
        }

        User user = service.getUserIfAuthenticated(username, password);

        if (user != null) {
            HttpSession session = request.getSession();
            session.setAttribute("user", user);
        } else {
            errors.add("Incorrect username or password");
        }

        if (errors.isEmpty()) {
            return forwardRequest("home", request, response);
        } else {
            request.setAttribute("errors", errors);
            return "login.jsp";
        }

    }

}
