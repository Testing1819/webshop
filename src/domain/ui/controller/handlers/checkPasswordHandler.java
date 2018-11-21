package domain.ui.controller.handlers;

import domain.ui.controller.RequestHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class checkPasswordHandler extends RequestHandler {

    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
        if (request.getMethod().equals("GET")) {
            Integer id = Integer.valueOf(request.getParameter("user"));
            request.setAttribute("user", service.getUser(id));
        } else if (request.getMethod().equals("POST")) {
            int id = Integer.valueOf(request.getParameter("id"));
            String password = request.getParameter("password");
            Boolean correctPassword = service.getUser(id).isPasswordCorrect(password);
            request.setAttribute("passwordCheck", correctPassword);
        }
        return "checkPassword.jsp";
    }
}
