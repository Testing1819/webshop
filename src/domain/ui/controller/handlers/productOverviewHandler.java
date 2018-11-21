package domain.ui.controller.handlers;

import domain.model.Product;
import domain.ui.controller.RequestHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class productOverviewHandler extends RequestHandler {
    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
        List<Product> products = service.getProducts();
        request.setAttribute("products", products);
        return "productoverview.jsp";
    }
}
