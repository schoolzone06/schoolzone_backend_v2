package schoolzone.schoolzone_backend_v2.domain.auth.service.client.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("oauth.google")
public record GoogleOAuthProperties(
        String clientId,
        String clientSecret,
        String grantType,
        String redirectUri
) {
}
