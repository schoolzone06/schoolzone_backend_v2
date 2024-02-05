package schoolzone.schoolzone_backend_v2.domain.comment.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import schoolzone.schoolzone_backend_v2.domain.comment.presentation.dto.request.CommentCreateRequestDto;
import schoolzone.schoolzone_backend_v2.domain.comment.service.implement.CommentSaveService;
import schoolzone.schoolzone_backend_v2.domain.user.service.UserService;

@Service
@RequiredArgsConstructor
public class CommentService {

    private final CommentSaveService commentSaveService;
    private final UserService userService;

    public Long create(CommentCreateRequestDto dto) {
        Long userId = userService.findCurrentUser().getId();
        return commentSaveService.create(userId, dto);
    }
}
