package domain.ui.controller.handlers.product;

import domain.model.Product;
import domain.model.Role;
import domain.ui.controller.RequestHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class viewHandler extends RequestHandler {

    public String handleGet(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.valueOf(request.getParameter("id"));
        Product album = service.getProduct(id);
        request.setAttribute("album", album);
        return "itemview.jsp";
    }


}