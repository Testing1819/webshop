package domain.ui.controller;

import domain.model.DatabaseModel;
import domain.model.ShopService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

public abstract class RequestHandler {

    protected ShopService service;

    public RequestHandler() {}

    public RequestHandler(ShopService service) {
        this.service = service;
    }

    public void setModel(ShopService service) {
        this.service = service;
    }

    protected List<String> createInstanceFromParameters(List<String> attributes, HttpServletRequest request, DatabaseModel instance) {
        List<String> errors = new ArrayList<>();

        for (String attributeName: attributes) {
            try {
                String attributeValue = request.getParameter(attributeName);
                instance.setAttribute(attributeName, attributeValue);
            } catch (IllegalArgumentException e) {
                errors.add(e.getMessage());
            }
        }
        return errors;
    }

    public abstract String handleRequest(HttpServletRequest request, HttpServletResponse response);
}
