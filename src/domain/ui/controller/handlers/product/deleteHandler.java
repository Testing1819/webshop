package domain.ui.controller.handlers.product;

import domain.model.Role;
import domain.ui.controller.RequestHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class deleteHandler extends RequestHandler {

    @Override
    public Role[] getAllowedRoles() {
        return new Role[]{Role.ADMIN};
    }

    public String handleDelete(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int productId = Integer.valueOf(request.getParameter("id"));
        service.deleteProduct(productId);
        return forwardRequest("product.overview", request, response);
    }

}
