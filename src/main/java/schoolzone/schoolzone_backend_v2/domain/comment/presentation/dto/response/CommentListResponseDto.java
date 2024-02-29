package schoolzone.schoolzone_backend_v2.domain.comment.presentation.dto.response;

import java.time.LocalDateTime;

public record CommentListResponseDto(
        Long commentId,
        String nickname,
        String content,
        LocalDateTime createdAt,
        Long likeCount,
        Long replyCount
) {
}
