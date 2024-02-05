package schoolzone.schoolzone_backend_v2.domain.comment.service.implement;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import schoolzone.schoolzone_backend_v2.domain.comment.domain.Comment;
import schoolzone.schoolzone_backend_v2.domain.comment.presentation.dto.request.CommentCreateRequestDto;
import schoolzone.schoolzone_backend_v2.domain.comment.presentation.dto.request.CommentUpdateRequestDto;
import schoolzone.schoolzone_backend_v2.domain.comment.repository.CommentRepository;

@Service
@RequiredArgsConstructor
@Transactional
public class CommentSaveService {

    private final CommentRepository commentRepository;

    public Long create(Long userId, CommentCreateRequestDto dto) {
        return save(dto.toEntity(userId));
    }

    public Long update(Comment comment, CommentUpdateRequestDto dto) {
        return save(comment.update(dto));
    }

    private Long save(Comment comment) {
        return commentRepository.save(comment).getId();
    }
}
