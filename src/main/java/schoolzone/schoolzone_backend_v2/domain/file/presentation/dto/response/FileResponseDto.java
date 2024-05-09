package schoolzone.schoolzone_backend_v2.domain.file.presentation.dto.response;

import org.springframework.core.io.Resource;

public record FileResponseDto(
        Resource resource,
        String contentType
) {
}
