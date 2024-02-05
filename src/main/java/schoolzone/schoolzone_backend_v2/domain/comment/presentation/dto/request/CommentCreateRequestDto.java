package schoolzone.schoolzone_backend_v2.domain.comment.presentation.dto.request;

import schoolzone.schoolzone_backend_v2.domain.comment.domain.Comment;

public record CommentCreateRequestDto(
        Long postId,
        String content
) {
    public Comment toEntity(Long userId) {
        return Comment.builder()
                .userId(userId)
                .postId(postId)
                .content(content)
                .build();
    }
}