package schoolzone.schoolzone_backend_v2.domain.comment.service.util;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import schoolzone.schoolzone_backend_v2.domain.comment.repository.CommentRepository;

import java.util.Objects;

@Service
@RequiredArgsConstructor
public class CommentUtil {

    private final CommentRepository commentRepository;

    public long commentCount(Long authorId, Long postId) {
        return commentRepository.countByPostId(authorId, postId);
    }

    public String generateNickname(Long userId, Long postAuthorId, Long commentCount) {
        if (Objects.equals(userId, postAuthorId)) {
            return "작성자";
        }

        return "익명" + commentCount + 1L;
    }
}
