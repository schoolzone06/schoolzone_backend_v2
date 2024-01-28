package schoolzone.schoolzone_backend_v2.domain.auth.service.implement;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import schoolzone.schoolzone_backend_v2.domain.auth.service.client.GoogleGetTokenClient;
import schoolzone.schoolzone_backend_v2.domain.auth.service.client.GoogleInfoClient;
import schoolzone.schoolzone_backend_v2.domain.auth.service.client.dto.request.GoogleTokenRequest;
import schoolzone.schoolzone_backend_v2.domain.auth.service.client.properties.GoogleOAuthProperties;

@Service
@RequiredArgsConstructor
public class AuthGoogleLoginService {

    private final GoogleGetTokenClient googleGetTokenClient;
    private final GoogleInfoClient googleInfoClient;
    private final GoogleOAuthProperties googleOAuthProperties;

    public String login(String code) {
        String googleAccessToken = googleGetTokenClient.getToken(
                new GoogleTokenRequest(
                        googleOAuthProperties.clientId(),
                        googleOAuthProperties.clientSecret(),
                        code,
                        googleOAuthProperties.grantType(),
                        googleOAuthProperties.redirectUri()
                )
        ).accessToken();

        return googleInfoClient.getUserInfo(googleAccessToken).email();
    }
}
