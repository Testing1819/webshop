package domain.ui.controller.handlers;

import domain.model.Product;
import domain.model.ShoppingCart;
import domain.ui.controller.HandlerFactory;
import domain.ui.controller.RequestHandler;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

public class seeQuoteHandler extends RequestHandler {
    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {

        if (request.getMethod().equals("POST")) {
            String showQuote = request.getParameter("seeQuote");
            Cookie cookie = new Cookie("seeQuote", showQuote);
            response.addCookie(cookie);
            request.setAttribute("showQuote", showQuote);

            return "index.jsp";
        } else {
            return "index.jsp";
        }
    }
}
