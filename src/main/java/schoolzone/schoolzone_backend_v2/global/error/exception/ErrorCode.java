package schoolzone.schoolzone_backend_v2.global.error.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ErrorCode {

    // auth
    REFRESH_TOKEN_NOT_FOUND(404, "AUTH-404-1", "Refresh Token이 존재하지 않습니다."),
    INVALID_REFRESH_TOKEN(401, "AUTH-401-1", "요청한 Refresh Token은 잘못된 토큰입니다."),

    // user
    USER_NOT_FOUND(404, "USER-404-1", "존재하지 않는 유저입니다."),

    // authentication
    AUTHENTICATION_NOT_FOUND(404, "AUTHENTICATION-404-1", "인증 요청 내역이 없습니다."),

    // jwt
    INVALID_TOKEN(403, "JWT-403-1", "잘못된 토큰입니다."),
    EXPIRED_TOKEN(403, "JWT-403-2", "토큰이 만료되었습니다."),

    // post
    POST_NOT_FOUND(404, "POST-404-1", "게시물을 찾을 수 없습니다."),

    // comment
    COMMENT_NOT_FOUND(404, "COMMENT-404-1", "댓글을 찾을 수 없습니다."),

    // reply
    REPLY_NOT_FOUND(404, "REPLY-404-1", "대댓글을 찾을 수 없습니다."),

    // server
    INTERNAL_SERVER_ERROR(500, "SERVER-500-1", "서버 에러"),

    // file
    FILE_SAVE_ERROR(500, "FILE-500-1", "파일 저장 중 오류가 발생했습니다."),
    FILE_NOT_FOUND(404, "FILE-404-1", "파일을 찾을 수 없습니다.");

    private final int status;
    private final String code;
    private final String message;
}
