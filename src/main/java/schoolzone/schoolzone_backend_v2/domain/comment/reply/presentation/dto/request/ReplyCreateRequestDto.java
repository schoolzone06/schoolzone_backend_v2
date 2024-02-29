package schoolzone.schoolzone_backend_v2.domain.comment.reply.presentation.dto.request;

import schoolzone.schoolzone_backend_v2.domain.comment.reply.domain.Reply;

public record ReplyCreateRequestDto(
        Long commentId,
        String content
) {
    public Reply toEntity(Long userId, String nickname) {
        return Reply.builder()
                .commentId(commentId)
                .userId(userId)
                .content(content)
                .nickname(nickname)
                .build();
    }
}
