package domain.ui.controller;

import domain.model.HandlerNotFoundException;
import domain.model.ServiceException;
import domain.model.ShopService;

import java.lang.reflect.InvocationTargetException;

public class HandlerFactory {

    public static RequestHandler getHandler(String handlerPath, ShopService model) throws ServiceException, HandlerNotFoundException {
        RequestHandler handler = null;

        String handlerName;
        String handlerCategory = null;

        if (handlerPath == null || handlerPath.equals("")) {
            throw new HandlerNotFoundException("");
        } else if (handlerPath.contains(".")) {
            String[] handlerParts = handlerPath.split("\\.");
            handlerCategory = handlerParts[0];
            handlerName = handlerParts[1];
        } else {
            handlerName = handlerPath;
        }

        try {
            String handlerFullName;
            if (handlerCategory != null && !handlerCategory.equals("")) {
                handlerFullName = "domain.ui.controller.handlers." + handlerCategory + "." + handlerName + "Handler";
            } else {
                handlerFullName = "domain.ui.controller.handlers." + handlerName + "Handler";
            }

            Class handlerClass = Class.forName(handlerFullName);
            Object handlerObject = handlerClass.getConstructor().newInstance();
            handler = (RequestHandler) handlerObject;
            handler.setModel(model);
        } catch (ClassNotFoundException | NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException e) {
            throw new HandlerNotFoundException("Handler " + handlerPath  + " was not found.");
        }
        return handler;
    }
}
