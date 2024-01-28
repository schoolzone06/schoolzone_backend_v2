package schoolzone.schoolzone_backend_v2.domain.auth.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import schoolzone.schoolzone_backend_v2.domain.auth.presentation.dto.response.AuthLoginResponseDto;
import schoolzone.schoolzone_backend_v2.domain.auth.service.implement.AuthGoogleLoginService;
import schoolzone.schoolzone_backend_v2.domain.user.domain.User;
import schoolzone.schoolzone_backend_v2.domain.user.service.UserService;
import schoolzone.schoolzone_backend_v2.global.jwt.util.JwtProvider;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserService userService;
    private final AuthGoogleLoginService authGoogleLoginService;
    private final JwtProvider jwtProvider;

    public AuthLoginResponseDto googleLogin(String code) {
        String email = authGoogleLoginService.login(code);

        if (!userService.isExistUser(email)) {
            User user = this.userService.createUser(email);
            this.userService.saveUser(user);
        }

        return new AuthLoginResponseDto(
                jwtProvider.accessToken(email),
                jwtProvider.refreshToken(email)
        );
    }

    // TODO: 1/28/24 logout / refresh token
}
