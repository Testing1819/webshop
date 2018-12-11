package domain.ui.controller.handlers.product;

import domain.model.Product;
import domain.model.Role;
import domain.ui.controller.RequestHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class modifyHandler extends RequestHandler {

    @Override
    public Role[] getAllowedRoles() {
        return new Role[]{Role.ADMIN};
    }

    public String handleGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int productId = Integer.valueOf(request.getParameter("id"));
        request.setAttribute("pageType", "UPDATE");

        Product product = service.getProduct(productId);
        request.setAttribute("product", product);
        return "productform.jsp";
    }

    public String handlePost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int productId = Integer.valueOf(request.getParameter("id"));
        request.setAttribute("pageType", "UPDATE");

        List<String> attributes = Arrays.asList("title", "artist", "description", "genre", "type", "price");
        Product product = new Product();
        List<String> errors = createInstanceFromParameters(attributes, request, product);
        product.setId(productId);

        if (errors.isEmpty() && !service.containsProduct(product.getId())) {
            errors.add("Product doesn't exist");
        }

        if (errors.isEmpty()) {
            service.updateProduct(product);
            return forwardRequest("product.overview", request, response);
        } else {
            request.setAttribute("errors", errors);
            return "productform.jsp";
        }
    }

}
