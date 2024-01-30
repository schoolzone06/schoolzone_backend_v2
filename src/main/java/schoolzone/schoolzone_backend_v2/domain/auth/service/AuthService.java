package schoolzone.schoolzone_backend_v2.domain.auth.service;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import schoolzone.schoolzone_backend_v2.domain.auth.domain.Authentication;
import schoolzone.schoolzone_backend_v2.domain.auth.domain.RefreshToken;
import schoolzone.schoolzone_backend_v2.domain.auth.presentation.dto.request.StudentIDVerityRequestDto;
import schoolzone.schoolzone_backend_v2.domain.auth.presentation.dto.response.AuthLoginResponseDto;
import schoolzone.schoolzone_backend_v2.domain.auth.presentation.dto.response.ReissueTokenResponseDto;
import schoolzone.schoolzone_backend_v2.domain.auth.service.implement.AuthGoogleLoginService;
import schoolzone.schoolzone_backend_v2.domain.user.domain.User;
import schoolzone.schoolzone_backend_v2.domain.user.service.UserService;
import schoolzone.schoolzone_backend_v2.global.error.exception.ErrorCode;
import schoolzone.schoolzone_backend_v2.global.error.exception.SchoolzoneException;
import schoolzone.schoolzone_backend_v2.global.jwt.util.JwtProvider;
import schoolzone.schoolzone_backend_v2.global.jwt.util.JwtUtil;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserService userService;
    private final AuthGoogleLoginService authGoogleLoginService;
    private final JwtProvider jwtProvider;
    private final AuthenticationService authenticationService;
    private final JwtUtil jwtUtil;
    private final RefreshTokenService refreshTokenService;

    public AuthLoginResponseDto googleLogin(String code) {
        String email = authGoogleLoginService.login(code);

        if (!userService.isExistUser(email)) {
            User user = this.userService.createUser(email);
            this.userService.saveUser(user);
        }

        Long userId = userService.findByEmail(email).getId();
        String accessToken = jwtProvider.accessToken(email);
        String refreshToken = jwtProvider.refreshToken(email);

        refreshTokenService.save(userId, accessToken, refreshToken);

        return new AuthLoginResponseDto(
                accessToken, refreshToken
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

    public ReissueTokenResponseDto reissueAccessToken(HttpServletRequest request) {
        String requestedRefreshToken = jwtUtil.resolveRefreshToken(request);
        String email = jwtUtil.extractEmail(requestedRefreshToken);
        String refreshToken = refreshTokenService.findRefreshToken(email).getRefreshToken();

        if (!requestedRefreshToken.equals(refreshToken)) {
            throw new SchoolzoneException(ErrorCode.INVALID_REFRESH_TOKEN);
        }

        return new ReissueTokenResponseDto(jwtProvider.accessToken(email));
    }

    public Long logout() {
        return refreshTokenService.delete();
    }
}
