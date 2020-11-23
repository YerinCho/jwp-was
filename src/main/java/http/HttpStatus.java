package http;

public enum HttpStatus {
    OK(200, "OK"),
    FOUND(302, "FOUND"),
    NOT_FOUND(404, "NOT FOUND"),
    METHOD_NOT_ALLOWED(405, "METHOD NOT ALLOWED"),
    NOT_IMPLEMENTED(501, "NOT IMPLEMENTED");

    private final int statusCode;
    private final String message;

    HttpStatus(int statusCode, String message) {
        this.statusCode = statusCode;
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public int getStatusCode() {
        return statusCode;
    }
}
