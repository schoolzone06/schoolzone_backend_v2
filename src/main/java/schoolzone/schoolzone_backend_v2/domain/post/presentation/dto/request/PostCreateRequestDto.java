package schoolzone.schoolzone_backend_v2.domain.post.presentation.dto.request;

import schoolzone.schoolzone_backend_v2.domain.post.domain.Post;
import schoolzone.schoolzone_backend_v2.domain.post.domain.enums.Category;
import schoolzone.schoolzone_backend_v2.domain.user.domain.User;

public record PostCreateRequestDto(
        String title,
        String content,
        Category category
) {
    public Post toEntity(User user) {
        return Post.builder()
                .title(title)
                .content(content)
                .category(category)
                .user(user)
                .build();
    }
}