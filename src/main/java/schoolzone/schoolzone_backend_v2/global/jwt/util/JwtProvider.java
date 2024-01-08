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

    public String accessToken(String phoneNum) {
        return createToken(phoneNum, jwtProperties.getAccessTokenExp(), ACCESS_TOKEN.getMessage());
    }

    public String refreshToken(String phoneNum) {
        return createToken(phoneNum, jwtProperties.getRefreshTokenExp(), REFRESH_TOKEN.getMessage());
    }

    private String createToken(String phoneNum, Long exp, String type) {
        Date now = new Date();

        Claims claims = Jwts.claims();
        claims.put(PHONE_NUMBER.getMessage(), phoneNum);

        return Jwts.builder()
                .setHeaderParam(TYPE.getMessage(), type)
                .setClaims(claims)
                .setIssuedAt(now)
                .setExpiration(new Date(now.getTime() + exp))
                .signWith(jwtProperties.getSecretKey(), SignatureAlgorithm.HS256)
                .compact();
    }
}
