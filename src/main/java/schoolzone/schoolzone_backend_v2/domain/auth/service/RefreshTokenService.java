package schoolzone.schoolzone_backend_v2.domain.auth.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import schoolzone.schoolzone_backend_v2.domain.auth.domain.RefreshToken;
import schoolzone.schoolzone_backend_v2.domain.auth.repository.RefreshTokenRepository;
import schoolzone.schoolzone_backend_v2.domain.user.service.UserService;
import schoolzone.schoolzone_backend_v2.global.error.exception.ErrorCode;
import schoolzone.schoolzone_backend_v2.global.error.exception.SchoolzoneException;
import schoolzone.schoolzone_backend_v2.global.jwt.properties.JwtProperties;

@Service
@RequiredArgsConstructor
public class RefreshTokenService {

    private final RefreshTokenRepository refreshTokenRepository;
    private final UserService userService;
    private final JwtProperties jwtProperties;

    @Transactional(readOnly = true)
    public RefreshToken findRefreshToken(String email) {
        Long userId = userService.findByEmail(email).getId();
        return refreshTokenRepository.findById(userId)
                .orElseThrow(() -> new SchoolzoneException(ErrorCode.REFRESH_TOKEN_NOT_FOUND));
    }

    @Transactional
    public Long save(Long userId, String accessToken, String refreshToken) {
        return refreshTokenRepository.save(
                RefreshToken.builder()
                        .userId(userId)
                        .accessToken(accessToken)
                        .refreshToken(refreshToken)
                        .ttl(jwtProperties.refreshTokenExp())
                        .build()
        ).getUserId();
    }

    @Transactional
    public Long delete() {
        Long userId = userService.findCurrentUser().getId();
        refreshTokenRepository.deleteById(userId);
        return userId;
    }
}
