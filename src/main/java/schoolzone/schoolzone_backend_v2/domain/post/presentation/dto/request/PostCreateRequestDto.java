package schoolzone.schoolzone_backend_v2.domain.post.presentation.dto.request;

import schoolzone.schoolzone_backend_v2.domain.post.domain.Post;
import schoolzone.schoolzone_backend_v2.domain.post.domain.enums.Category;

public record PostCreateRequestDto(
        String title,
        String content,
        Category category
) {
    public Post toEntity(Long authorId) {
        return Post.builder()
                .authorId(authorId)
                .title(title)
                .content(content)
                .category(category)
                .build();
    }
}