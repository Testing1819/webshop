package domain.ui.controller.handlers;

import domain.ui.controller.RequestHandler;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;

public class homeHandler extends RequestHandler {

    public String handleGet(HttpServletRequest request, HttpServletResponse response) {
        Cookie[] cookies = request.getCookies();
        Cookie quoteCookie = null;
        try {
            quoteCookie = Arrays.stream(cookies).filter(cookie -> cookie.getName().equals("seeQuote")).findFirst().orElse(null);

        }
        catch (Exception e) {

        }

        request.setAttribute("showQuote", "false");
        if (quoteCookie != null) {
            request.setAttribute("showQuote", quoteCookie.getValue());
        }

        request.setAttribute("bannerAlbums", service.getProducts(5));
        request.setAttribute("albums", service.getProducts());

        return "index.jsp";
    }
}
