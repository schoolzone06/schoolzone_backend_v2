package schoolzone.schoolzone_backend_v2.domain.comment.reply.service.implement;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import schoolzone.schoolzone_backend_v2.domain.comment.reply.domain.Reply;
import schoolzone.schoolzone_backend_v2.domain.comment.reply.repository.ReplyRepository;
import schoolzone.schoolzone_backend_v2.global.error.exception.ErrorCode;
import schoolzone.schoolzone_backend_v2.global.error.exception.SchoolzoneException;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ReplyGetService {

    private final ReplyRepository replyRepository;

    public Reply findByReplyId(Long replyId) {
        return replyRepository.findById(replyId)
                .orElseThrow(() -> new SchoolzoneException(ErrorCode.REPLY_NOT_FOUND));
    }

    public List<Reply> findByCommentId(Long commentId) {
        return replyRepository.findByCommentId(commentId);
    }
}
