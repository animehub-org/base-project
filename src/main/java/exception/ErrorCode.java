package exception;

public enum ErrorCode {
    // Use simple, descriptive integer codes
    NOT_FOUND(404),
    BAD_REQUEST(400),
    UNAUTHORIZED(401),
    FORBIDDEN(403),
    INTERNAL_SERVER_ERROR(500),
    VALIDATION_ERROR(400),
    INVALID_CAPTCHA(422), // 422 Unprocessable Entity
    INVALID_TOKEN(401),
    EXISTS(409); // 409 Conflict

    private final int httpStatusCode;

    ErrorCode(int httpStatusCode) {
        this.httpStatusCode = httpStatusCode;
    }

    public int getHttpStatusCode() {
        return httpStatusCode;
    }
}