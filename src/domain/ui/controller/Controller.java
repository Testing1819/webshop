package domain.ui.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.*;

import javax.servlet.FilterChain;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;

import domain.db.*;
import domain.model.*;

@WebServlet("/Controller")
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ShopService shopService;

	@Override
	public void init() throws ServletException {
		super.init();
		ServletContext context = getServletContext();

		Properties properties = new Properties();
		Enumeration<String> parameterNames = context.getInitParameterNames();
		while (parameterNames.hasMoreElements()){
			String propertyName = parameterNames.nextElement();
			properties.setProperty(propertyName, context.getInitParameter(propertyName));
		}

		shopService = new ShopService(properties);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

	private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String destination;
		String handler = request.getParameter("handler");

		if (handler == null || handler.equals("")) {
			handler = "home";
		}

		try {
			destination = HandlerFactory.getHandler(handler, shopService).handleRequest(request, response);
		} catch (HandlerNotFoundException e) {
			e.printStackTrace();
			destination = "error404.jsp";
		} catch (NotAuthorizedException e) {
			request.setAttribute("notAuthorized", "You have insufficient rights to access this page");
			destination = "error404.jsp";
		}

		request.getRequestDispatcher(destination).forward(request, response);
	}
}
