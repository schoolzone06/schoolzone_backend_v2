package schoolzone.schoolzone_backend_v2.global.jwt.properties;


import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import lombok.Getter;
import org.springframework.boot.context.properties.ConfigurationProperties;

import javax.crypto.SecretKey;

@Getter
@ConfigurationProperties(prefix = "jwt")
public class JwtProperties {

    private final SecretKey secretKey;
    private final Long accessTokenExp;
    private final Long refreshTokenExp;

    public JwtProperties(String secretKey, Long accessTokenExp, Long refreshTokenExp) {
        this.secretKey = Keys.hmacShaKeyFor(Decoders.BASE64.decode(secretKey));
        this.accessTokenExp = accessTokenExp;
        this.refreshTokenExp = refreshTokenExp;
    }
}
