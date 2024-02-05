package schoolzone.schoolzone_backend_v2.domain.comment.service.implement;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import schoolzone.schoolzone_backend_v2.domain.comment.domain.Comment;
import schoolzone.schoolzone_backend_v2.domain.comment.repository.CommentRepository;
import schoolzone.schoolzone_backend_v2.global.error.exception.ErrorCode;
import schoolzone.schoolzone_backend_v2.global.error.exception.SchoolzoneException;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class CommentGetService {

    private final CommentRepository commentRepository;

    public long commentCount(Long postId) {
        return commentRepository.countByPostId(postId);
    }

    public Comment findOne(Long commentId) {
        return commentRepository.findById(commentId)
                .orElseThrow(() -> new SchoolzoneException(ErrorCode.COMMENT_NOT_FOUND));
    }
}
