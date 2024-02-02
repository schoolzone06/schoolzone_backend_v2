package schoolzone.schoolzone_backend_v2.domain.post.presentation.dto.request;

public record PostUpdateRequestDto(
        String title,
        String content
) {
}