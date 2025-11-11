package response;

import exception.ErrorCode;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.Instant;

@Builder
@NoArgsConstructor
@Getter
public class ApiResponse<T> implements Serializable {
    boolean success;
    T data;
    String message;
    Instant timestamp;
    ErrorCode errorCode;

    public ApiResponse(T data){
        this(true, data, null, Instant.now(), null);
    }
    public ApiResponse(boolean success, String message){
        this(success, null, message, Instant.now(), null);
    }
    public ApiResponse(T data, String message){
        this(true, data, message, Instant.now(), null);
    }
    public ApiResponse(String message, ErrorCode errorCode){
        this(false, null, message, Instant.now(), errorCode);
    }

    private ApiResponse(boolean success, T data, String message, Instant timestamp, ErrorCode errorCode){
        this.success = success;
        this.data = data;
        this.message = message;
        this.timestamp = timestamp;
        this.errorCode = errorCode;
    }

    public static <T> ApiResponse<T> error(String message, ErrorCode errorCode){
        return new ApiResponse<>(message, errorCode);
    }

    public static <T> ApiResponse<T> setSuccess(T data, String message){
        return new ApiResponse<>(data, message);
    }
    public static <T> ApiResponse<T> setSuccess(T data) {
        return new ApiResponse<>(data);
    }
}
