package schoolzone.schoolzone_backend_v2.global.jwt.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import schoolzone.schoolzone_backend_v2.global.jwt.properties.JwtProperties;

import java.util.Date;

import static schoolzone.schoolzone_backend_v2.global.jwt.properties.JwtConstants.*;

@Component
@RequiredArgsConstructor
public class JwtProvider {

    private final JwtProperties jwtProperties;

    public String accessToken(String email) {
        return createToken(email, jwtProperties.accessTokenExp(), ACCESS_TOKEN.getMessage());
    }

    public String refreshToken(String email) {
        return createToken(email, jwtProperties.refreshTokenExp(), REFRESH_TOKEN.getMessage());
    }

    private String createToken(String email, Long exp, String type) {
        Date now = new Date();

        Claims claims = Jwts.claims();
        claims.put(EMAIL.getMessage(), email);

        return Jwts.builder()
                .setHeaderParam(TYPE.getMessage(), type)
                .setClaims(claims)
                .setIssuedAt(now)
                .setExpiration(new Date(now.getTime() + exp))
                .signWith(jwtProperties.secretKey(), SignatureAlgorithm.HS256)
                .compact();
    }
}
