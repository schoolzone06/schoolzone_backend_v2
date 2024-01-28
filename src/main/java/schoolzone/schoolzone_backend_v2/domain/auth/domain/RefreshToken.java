package schoolzone.schoolzone_backend_v2.domain.auth.domain;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.TimeToLive;
import org.springframework.data.redis.core.index.Indexed;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder
@RedisHash(value = "sz-rt")
public class RefreshToken {

    @Id
    private Long userId;

    @Indexed
    private String refreshToken;

    private String accessToken;

    @TimeToLive
    private Long ttl;
}
