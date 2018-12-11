package domain.ui.controller;

import domain.model.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public abstract class RequestHandler {

    protected ShopService service;

    public RequestHandler() {
    }

    public RequestHandler(ShopService service) {
        this.service = service;
    }

    public void setModel(ShopService service) {
        this.service = service;
    }

    protected List<String> createInstanceFromParameters(List<String> attributes, HttpServletRequest request, DatabaseModel instance) {
        List<String> errors = new ArrayList<>();

        for (String attributeName : attributes) {
            try {
                String attributeValue = request.getParameter(attributeName);
                instance.setAttribute(attributeName, attributeValue);
            } catch (IllegalArgumentException e) {
                errors.add(e.getMessage());
            }
        }
        return errors;
    }

    public String forwardRequest(String handler, HttpServletRequest request, HttpServletResponse response) throws IOException {
        try {
            request.setAttribute("forwarded", true);
            return HandlerFactory.getHandler(handler, service).handleRequest(request, response);
        } catch (HandlerNotFoundException e) {
            e.printStackTrace();
            return "error404.jsp";
        }
    }

    public void checkRole(HttpServletRequest request, Role[] roles) {
        boolean found = false;
        User user = (User) request.getSession().getAttribute("user");
        if (user != null) {
            for (Role role: roles) {
                if (user.getRole().equals(role.name())) {
                    found = true;
                }
            }
        } else {
            for (Role role: roles) {
                if (role == Role.VISITOR) {
                    found = true;
                }
            }
        }
        if (!found) {
            throw new NotAuthorizedException();
        }
    }

    public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // Forwarded requests need to be seen as GET requests

        checkRole(request, getAllowedRoles());

        Object forwarded = request.getAttribute("forwarded");
        if (forwarded != null && (boolean) forwarded) {
            return handleGet(request, response);
        }

        switch (request.getMethod().toUpperCase()) {
            case "GET":
                return handleGet(request, response);
            case "POST":
                return handlePost(request, response);
            case "DELETE":
                return handleDelete(request, response);
            default:
                return null;
        }
    }

    public Role[] getAllowedRoles() {return new Role[]{Role.ADMIN, Role.CUSTOMER, Role.VISITOR};}

    public String handleGet(HttpServletRequest request, HttpServletResponse response) throws IOException { return null;}
    public String handlePost(HttpServletRequest request, HttpServletResponse response) throws IOException { return null;}
    public String handleDelete(HttpServletRequest request, HttpServletResponse response) throws IOException { return null;}
}
