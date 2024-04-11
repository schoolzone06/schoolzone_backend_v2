package schoolzone.schoolzone_backend_v2.global.jwt.properties;


import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.bind.ConstructorBinding;

import javax.crypto.SecretKey;

@ConfigurationProperties(prefix = "jwt")
public record JwtProperties(
        SecretKey secretKey,
        Long accessTokenExp,
        Long refreshTokenExp
) {

    @ConstructorBinding
    public JwtProperties(String secretKey, Long accessTokenExp, Long refreshTokenExp) {
        this(
                Keys.hmacShaKeyFor(Decoders.BASE64.decode(secretKey)),
                accessTokenExp,
                refreshTokenExp
        );
    }
}
