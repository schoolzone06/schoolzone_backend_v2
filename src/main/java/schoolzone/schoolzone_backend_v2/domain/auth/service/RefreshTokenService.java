package schoolzone.schoolzone_backend_v2.domain.auth.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import schoolzone.schoolzone_backend_v2.domain.auth.domain.RefreshToken;
import schoolzone.schoolzone_backend_v2.domain.auth.repository.RefreshTokenRepository;
import schoolzone.schoolzone_backend_v2.domain.user.service.UserService;
import schoolzone.schoolzone_backend_v2.global.error.exception.ErrorCode;
import schoolzone.schoolzone_backend_v2.global.error.exception.SchoolzoneException;

@Service
@RequiredArgsConstructor
public class RefreshTokenService {

    private final RefreshTokenRepository refreshTokenRepository;
    private final UserService userService;

    @Transactional(readOnly = true)
    public RefreshToken findRefreshToken(String email) {
        Long userId = userService.findByEmail(email).getId();
        return refreshTokenRepository.findById(userId)
                .orElseThrow(() -> new SchoolzoneException(ErrorCode.REFRESH_TOKEN_NOT_FOUND));
    }
}
