package schoolzone.schoolzone_backend_v2.domain.post.application;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import schoolzone.schoolzone_backend_v2.domain.post.application.implement.PostGetService;
import schoolzone.schoolzone_backend_v2.domain.post.application.implement.PostSaveService;
import schoolzone.schoolzone_backend_v2.domain.post.domain.Post;
import schoolzone.schoolzone_backend_v2.domain.post.presentation.dto.request.PostCreateRequestDto;
import schoolzone.schoolzone_backend_v2.domain.post.presentation.dto.request.PostUpdateRequestDto;
import schoolzone.schoolzone_backend_v2.domain.user.service.UserService;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostGetService postGetService;
    private final PostSaveService postSaveService;
    private final UserService userService;

    public Long create(PostCreateRequestDto dto) {
        Long authorId = userService.findCurrentUser().getId();
        return postSaveService.create(dto.toEntity(authorId));
    }

    public Long update(Long postId, PostUpdateRequestDto dto) {
        Post post = postGetService.findOne(postId);
        return postSaveService.update(post, dto);
    }

    public Long delete(Long postId) {
        return postSaveService.delete(postId);
    }
}
