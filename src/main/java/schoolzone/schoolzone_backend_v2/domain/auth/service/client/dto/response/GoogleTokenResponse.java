package schoolzone.schoolzone_backend_v2.domain.auth.service.client.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public record GoogleTokenResponse(
        @JsonProperty("access_token") String accessToken
) {}
