package domain.model;

public class NotAuthorizedException extends RuntimeException {
    private static final long serialVersionUID = 1l;

    public NotAuthorizedException() {
        super();
    }

    public NotAuthorizedException(String message) {
        super(message);
    }
}
