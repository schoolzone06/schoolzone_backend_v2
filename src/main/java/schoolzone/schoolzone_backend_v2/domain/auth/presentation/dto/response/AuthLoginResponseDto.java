package schoolzone.schoolzone_backend_v2.domain.auth.presentation.dto.response;

public record AuthLoginResponseDto(
        String accessToken,
        String refreshToken
) {
}
