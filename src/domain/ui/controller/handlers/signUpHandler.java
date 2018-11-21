package domain.ui.controller.handlers;

import domain.model.Person;
import domain.ui.controller.HandlerFactory;
import domain.ui.controller.RequestHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;
import java.util.List;

public class signUpHandler extends RequestHandler {

    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
        if (request.getMethod().equals("POST")) {

            List<String> attributes = Arrays.asList("id", "firstName", "lastName", "email");
            Person person = new Person();

            List<String> errors = createInstanceFromParameters(attributes, request, person);

            try {
                person.setUnhashedPassword(request.getParameter("password"));
            } catch (IllegalArgumentException e) {
                errors.add(e.getMessage());
            }

            if (errors.isEmpty() && service.containsUser(person.getId())) {
                errors.add("User already exists");
            }

            if (errors.isEmpty()) {
                service.addUser(person);
                return HandlerFactory.getHandler("home", service).handleRequest(request, response);
            } else {
                request.setAttribute("errors", errors);
                return "signUp.jsp";
            }
        } else {
            return "signUp.jsp";
        }
    }
}
