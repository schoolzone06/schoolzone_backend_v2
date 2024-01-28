package schoolzone.schoolzone_backend_v2.domain.auth.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import schoolzone.schoolzone_backend_v2.domain.auth.presentation.dto.response.AuthLoginResponseDto;
import schoolzone.schoolzone_backend_v2.domain.auth.service.implement.AuthGoogleLoginService;
import schoolzone.schoolzone_backend_v2.domain.auth.service.implement.AuthSignupService;
import schoolzone.schoolzone_backend_v2.domain.user.domain.User;
import schoolzone.schoolzone_backend_v2.global.jwt.util.JwtProvider;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final AuthSignupService authSignupService;
    private final AuthGoogleLoginService authGoogleLoginService;
    private final JwtProvider jwtProvider;

    public AuthLoginResponseDto googleLogin(String code) {
        String email = authGoogleLoginService.login(code);

        if (!authSignupService.isExistUser(email)) {
            User user = authSignupService.createUser(email);
            authSignupService.saveUser(user);
        }

        return new AuthLoginResponseDto(
                jwtProvider.accessToken(email),
                jwtProvider.refreshToken(email)
        );
    }

    // TODO: 1/28/24 logout / refresh token
}
