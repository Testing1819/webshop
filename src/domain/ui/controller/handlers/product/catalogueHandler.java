package domain.ui.controller.handlers.product;

import domain.model.Product;
import domain.ui.controller.RequestHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class catalogueHandler extends RequestHandler {

    public String handleGet(HttpServletRequest request, HttpServletResponse response) {
        List<Product> products = service.getProducts();
        request.setAttribute("products", products);
        return "catalogue.jsp";
    }


}
