package schoolzone.schoolzone_backend_v2.domain.auth.service.client.dto.request;

public record GoogleTokenRequest(
        String clientId,
        String clientSecret,
        String code,
        String grantType,
        String redirectUri
) {}
