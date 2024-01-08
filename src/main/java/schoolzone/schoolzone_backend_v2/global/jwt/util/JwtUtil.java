package schoolzone.schoolzone_backend_v2.global.jwt.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;
import schoolzone.schoolzone_backend_v2.global.jwt.properties.JwtProperties;
import schoolzone.schoolzone_backend_v2.global.security.auth.AuthDetails;
import schoolzone.schoolzone_backend_v2.global.security.auth.AuthDetailsService;

@Component
@RequiredArgsConstructor
public class JwtUtil {

    private final JwtProperties jwtProperties;
    private final AuthDetailsService authDetailsService;

    public Authentication getAuthentication(String token) {
        AuthDetails authDetails = (AuthDetails) authDetailsService.loadUserByUsername(extractPhoneNumber(token));

        return new UsernamePasswordAuthenticationToken(authDetails, token, authDetails.getAuthorities());
    }

    public String resolveToken(HttpServletRequest request) {
        String bearer = request.getHeader("Authorization");

        if (bearer == null || !bearer.startsWith("Bearer ")) {
            return null;
        }

        return bearer.split(" ")[1].trim();
    }

    public Claims getClaims(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(jwtProperties.secretKey())
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

    public String extractPhoneNumber(String token) {
        return getClaims(token).get("phoneNum").toString();
    }
}
