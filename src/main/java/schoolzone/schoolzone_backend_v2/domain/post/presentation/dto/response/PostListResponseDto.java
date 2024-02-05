package schoolzone.schoolzone_backend_v2.domain.post.presentation.dto.response;

import java.time.LocalDateTime;

public record PostListResponseDto(
        Long postId,
        String title,
        String content,
        LocalDateTime createdAt,
        Long likeCount,
        Long commentCount
) {
}
