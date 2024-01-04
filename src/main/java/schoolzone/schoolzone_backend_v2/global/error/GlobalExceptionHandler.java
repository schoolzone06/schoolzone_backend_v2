package schoolzone.schoolzone_backend_v2.global.error;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import schoolzone.schoolzone_backend_v2.global.error.exception.ErrorCode;
import schoolzone.schoolzone_backend_v2.global.error.exception.SchoolzoneException;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(SchoolzoneException.class)
    public ResponseEntity<ErrorResponse> nodamExceptionHandler(SchoolzoneException e) {
        ErrorCode errorCode = e.getErrorCode();

        return ResponseEntity
                .status(HttpStatus.valueOf(errorCode.getStatus()))
                .body(
                        new ErrorResponse(
                                errorCode.getStatus(),
                                errorCode.getCode(),
                                errorCode.getMessage()
                        )
                );
    }
}
