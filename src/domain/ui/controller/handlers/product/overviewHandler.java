package domain.ui.controller.handlers.product;

import domain.model.Product;
import domain.model.Role;
import domain.ui.controller.RequestHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class overviewHandler extends RequestHandler {

    @Override
    public Role[] getAllowedRoles() {
        return new Role[]{Role.ADMIN};
    }

    public String handleGet(HttpServletRequest request, HttpServletResponse response) {
        List<Product> products = service.getProducts();
        request.setAttribute("products", products);
        return "productoverview.jsp";
    }


}
