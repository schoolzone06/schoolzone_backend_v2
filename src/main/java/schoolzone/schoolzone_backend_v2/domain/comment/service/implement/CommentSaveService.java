package schoolzone.schoolzone_backend_v2.domain.comment.service.implement;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import schoolzone.schoolzone_backend_v2.domain.comment.domain.Comment;
import schoolzone.schoolzone_backend_v2.domain.comment.presentation.dto.request.CommentCreateRequestDto;
import schoolzone.schoolzone_backend_v2.domain.comment.presentation.dto.request.CommentUpdateRequestDto;
import schoolzone.schoolzone_backend_v2.domain.comment.repository.CommentRepository;

import java.util.Objects;

@Service
@RequiredArgsConstructor
@Transactional
public class CommentSaveService {

    private final CommentRepository commentRepository;

    public Long create(Long userId, String nickname, CommentCreateRequestDto dto) {
        return save(dto.toEntity(userId, nickname));
    }

    public Long update(Comment comment, CommentUpdateRequestDto dto) {
        return save(comment.update(dto));
    }

    public Long delete(Long commentId) {
        commentRepository.deleteById(commentId);
        return commentId;
    }

    private Long save(Comment comment) {
        return commentRepository.save(comment).getId();
    }

    public String generateNickname(Long userId, Long postAuthorId, Long commentCount) {
        if (Objects.equals(userId, postAuthorId)) {
            return "작성자";
        }

        return "익명" + commentCount + 1L;
    }
}
