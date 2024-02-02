package schoolzone.schoolzone_backend_v2.domain.auth.presentation.dto.request;

import schoolzone.schoolzone_backend_v2.domain.auth.domain.Authentication;

public record StudentIDVerityRequestDto(
        Long userId,
        String studentIDCardUrl
) {
    public Authentication toEntity() {
        return Authentication.builder()
                .userId(userId)
                .studentIDCardUrl(studentIDCardUrl)
                .build();
    }
}
