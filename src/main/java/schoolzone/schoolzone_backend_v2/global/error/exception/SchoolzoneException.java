package schoolzone.schoolzone_backend_v2.global.error.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class SchoolzoneException extends RuntimeException {

    private final ErrorCode errorCode;
}
