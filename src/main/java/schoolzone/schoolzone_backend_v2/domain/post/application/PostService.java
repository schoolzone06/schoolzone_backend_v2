package schoolzone.schoolzone_backend_v2.domain.post.application;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import schoolzone.schoolzone_backend_v2.domain.post.application.implement.PostSaveService;
import schoolzone.schoolzone_backend_v2.domain.post.presentation.dto.request.PostCreateRequestDto;
import schoolzone.schoolzone_backend_v2.domain.user.service.UserService;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostSaveService postSaveService;
    private final UserService userService;

    public Long create(PostCreateRequestDto dto) {
        Long authorId = userService.findCurrentUser().getId();
        return postSaveService.create(dto.toEntity(authorId));
    }
}
