package schoolzone.schoolzone_backend_v2.global.error.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ErrorCode {

    // user
    USER_NOT_FOUND(404, "USER-404-1", "존재하지 않는 유저입니다."),

    // jwt
    INVALID_TOKEN(403, "JWT-403-1", "잘못된 토큰입니다."),
    EXPIRED_TOKEN(403, "JWT-403-2", "토큰이 만료되었습니다."),

    // server
    INTERNAL_SERVER_ERROR(500, "SERVER-500-1", "서버 에러");

    private final int status;
    private final String code;
    private final String message;
}
