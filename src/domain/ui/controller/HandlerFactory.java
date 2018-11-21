package domain.ui.controller;

import domain.model.ServiceException;
import domain.model.ShopService;

import java.lang.reflect.InvocationTargetException;

public class HandlerFactory {

    public static RequestHandler getHandler(String handlerName, ShopService model) throws ServiceException {
        RequestHandler handler = null;
        try {
            Class handlerClass = Class.forName("domain.ui.controller.handlers."+handlerName+"Handler");
            Object handlerObject = handlerClass.getConstructor().newInstance();
            handler = (RequestHandler) handlerObject;
            handler.setModel(model);
        } catch (ClassNotFoundException | NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException e) {
            throw new ServiceException(e);
        }
        return handler;
    }
}
