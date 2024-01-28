package schoolzone.schoolzone_backend_v2.domain.auth.service.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import schoolzone.schoolzone_backend_v2.domain.auth.service.client.dto.response.GoogleInfoResponse;

@FeignClient(
        value = "GoogleInfoClient",
        url = "https://www.googleapis.com"
)
public interface GoogleInfoClient {

    @GetMapping("/oauth2/v1/userinfo?access_token={accessToken}")
    GoogleInfoResponse getUserInfo(@PathVariable("accessToken") String token);
}
