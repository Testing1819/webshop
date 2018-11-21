package domain.ui.controller.handlers;

import domain.model.Product;
import domain.ui.controller.HandlerFactory;
import domain.ui.controller.RequestHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;
import java.util.List;

public class addProductHandler extends RequestHandler {

    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
        request.setAttribute("pageType", "CREATE");
        if (request.getMethod().equals("POST")) {

            List<String> attributes = Arrays.asList("name", "description", "price");
            Product product = new Product();
            List<String> errors = createInstanceFromParameters(attributes, request, product);

            product.setId(service.getNrOfProducts());

            if (errors.isEmpty() && service.containsProduct(product.getId())) {
                errors.add("Product already exists");
            }

            if (errors.isEmpty()) {
                service.addProduct(product);
                return HandlerFactory.getHandler("productOverview", service).handleRequest(request, response);
            } else {
                request.setAttribute("errors", errors);
                return "productform.jsp";
            }
        } else if (request.getMethod().equals("GET")) {
            return "productform.jsp";
        }
        return HandlerFactory.getHandler("productOverview", service).handleRequest(request, response);
    }
}
