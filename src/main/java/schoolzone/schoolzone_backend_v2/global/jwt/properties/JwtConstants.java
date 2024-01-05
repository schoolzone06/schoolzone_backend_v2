package schoolzone.schoolzone_backend_v2.global.jwt.properties;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum JwtConstants {

    TYPE("type"),

    USER_ID("userId"),

    ACCESS_TOKEN("access_token"),
    REFRESH_TOKEN("refresh_token");

    private final String message;
}
