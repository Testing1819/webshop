package domain.ui.controller.handlers;

import domain.ui.controller.HandlerFactory;
import domain.ui.controller.RequestHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class deleteProductHandler extends RequestHandler {
    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
        int productId = Integer.valueOf(request.getParameter("id"));
        service.deleteProduct(productId);
        return HandlerFactory.getHandler("productOverview", service).handleRequest(request, response);
    }
}
