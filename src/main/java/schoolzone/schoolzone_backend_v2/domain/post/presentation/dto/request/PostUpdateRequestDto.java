package schoolzone.schoolzone_backend_v2.domain.post.presentation.dto.request;

import schoolzone.schoolzone_backend_v2.domain.post.domain.Post;

public record PostUpdateRequestDto(
        String title,
        String content
) {
    public Post toEntity() {
        return Post.builder()
                .title(title)
                .content(content)
                .build();
    }
}