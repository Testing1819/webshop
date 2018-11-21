package domain.ui.controller.handlers;

import domain.model.Product;
import domain.ui.controller.HandlerFactory;
import domain.ui.controller.RequestHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;
import java.util.List;

public class modifyProductHandler extends RequestHandler {
    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
        int productId = Integer.valueOf(request.getParameter("id"));
        request.setAttribute("pageType", "UPDATE");

        if (request.getMethod().equals("GET") && request.getParameter("id") != null) {
            Product product = service.getProduct(productId);
            request.setAttribute("product", product);
            return "productform.jsp";
        } else if (request.getMethod().equals("POST")) {
            List<String> attributes = Arrays.asList("name", "description", "price");
            Product product = new Product();
            List<String> errors = createInstanceFromParameters(attributes, request, product);
            product.setId(productId);

            if (errors.isEmpty() && !service.containsProduct(product.getId())) {
                errors.add("Product doesn't exist");
            }

            if (errors.isEmpty()) {
                service.updateProduct(product);
                return HandlerFactory.getHandler("productOverview", service).handleRequest(request, response);
            } else {
                request.setAttribute("errors", errors);
                return "productform.jsp";
            }
        }
        return HandlerFactory.getHandler("productOverview", service).handleRequest(request, response);
    }
}