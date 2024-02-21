package schoolzone.schoolzone_backend_v2.domain.comment.reply.presentation.dto.response;

public record ReplyListGetResponseDto(
        Long id,
        Long commentId,
        String content,
        String nickname,
        Long likeCount
) {
}
