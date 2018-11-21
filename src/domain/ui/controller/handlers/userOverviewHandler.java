package domain.ui.controller.handlers;

import domain.model.Person;
import domain.ui.controller.RequestHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class userOverviewHandler extends RequestHandler {
    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
        List<Person> persons = service.getUsers();
        request.setAttribute("users", persons);
        return "personoverview.jsp";
    }
}
