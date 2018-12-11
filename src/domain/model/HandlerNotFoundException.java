package domain.model;

public class HandlerNotFoundException extends Exception {

    private static final long serialVersionUID = 1L;

    public HandlerNotFoundException() {
        super();
    }

    public HandlerNotFoundException(String message, Throwable exception) {
        super(message, exception);
    }

    public HandlerNotFoundException(String message) {
        super(message);
    }

    public HandlerNotFoundException(Throwable exception) {
        super(exception);
    }

}
