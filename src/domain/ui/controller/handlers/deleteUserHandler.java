package domain.ui.controller.handlers;

import domain.ui.controller.HandlerFactory;
import domain.ui.controller.RequestHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class deleteUserHandler extends RequestHandler {
    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
        Integer id = Integer.valueOf(request.getParameter("id"));
        service.deleteUser(id);
        return HandlerFactory.getHandler("userOverview", service).handleRequest(request, response);
    }
}
