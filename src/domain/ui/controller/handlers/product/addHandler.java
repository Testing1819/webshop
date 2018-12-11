package domain.ui.controller.handlers.product;

import domain.model.Product;
import domain.model.Role;
import domain.ui.controller.RequestHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class addHandler extends RequestHandler {

    @Override
    public Role[] getAllowedRoles() {
        return new Role[]{Role.ADMIN};
    }

    public String handleGet(HttpServletRequest request, HttpServletResponse response) {
        request.setAttribute("pageType", "CREATE");
        return "productform.jsp";
    }

    public String handlePost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setAttribute("pageType", "CREATE");
        List<String> attributes = Arrays.asList("title", "artist", "description", "genre", "type", "price");
        Product product = new Product();
        List<String> errors = createInstanceFromParameters(attributes, request, product);

        product.setId(service.getNrOfProducts());

        if (errors.isEmpty() && service.containsProduct(product.getId())) {
            errors.add("Product already exists");
        }

        if (errors.isEmpty()) {
            service.addProduct(product);
            return forwardRequest("product.catalogue", request, response);
        } else {
            request.setAttribute("errors", errors);
            return "productform.jsp";
        }

    }

}
