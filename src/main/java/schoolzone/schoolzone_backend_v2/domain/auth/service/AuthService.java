package schoolzone.schoolzone_backend_v2.domain.auth.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import schoolzone.schoolzone_backend_v2.domain.auth.domain.Authentication;
import schoolzone.schoolzone_backend_v2.domain.auth.presentation.dto.request.StudentIDVerityRequestDto;
import schoolzone.schoolzone_backend_v2.domain.auth.presentation.dto.response.AuthLoginResponseDto;
import schoolzone.schoolzone_backend_v2.domain.auth.service.implement.AuthGoogleLoginService;
import schoolzone.schoolzone_backend_v2.domain.user.domain.User;
import schoolzone.schoolzone_backend_v2.domain.user.service.UserService;
import schoolzone.schoolzone_backend_v2.global.jwt.util.JwtProvider;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserService userService;
    private final AuthGoogleLoginService authGoogleLoginService;
    private final JwtProvider jwtProvider;
    private final AuthenticationService authenticationService;

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

    public List<Authentication> findVerifyRequest() {
        return authenticationService.findAll();
    }

    public Long saveVerifyRequest(StudentIDVerityRequestDto dto) {
        return authenticationService.create(dto.toEntity());
    }

    public Long verifyUser(Long verifyId) {
        Long userId = authenticationService.findById(verifyId).getUserId();
        authenticationService.delete(verifyId);
        return userService.verify(userId);
    }

    // TODO: 1/28/24 logout / refresh token
}
