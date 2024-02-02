package schoolzone.schoolzone_backend_v2.domain.auth.service.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import schoolzone.schoolzone_backend_v2.domain.auth.service.client.dto.request.GoogleTokenRequest;
import schoolzone.schoolzone_backend_v2.domain.auth.service.client.dto.response.GoogleTokenResponse;

@FeignClient(
        value = "GoogleGetTokenClient",
        url = "https://oauth2.googleapis.com"
)
public interface GoogleGetTokenClient {

    @PostMapping("/token")
    GoogleTokenResponse getToken(GoogleTokenRequest request);
}
