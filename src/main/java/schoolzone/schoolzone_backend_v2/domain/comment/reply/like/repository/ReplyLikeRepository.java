package schoolzone.schoolzone_backend_v2.domain.comment.reply.like.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import schoolzone.schoolzone_backend_v2.domain.comment.reply.like.domain.ReplyLike;

public interface ReplyLikeRepository extends JpaRepository<ReplyLike, Long> {

    void deleteByReplyIdAndUserId(Long replyId, Long userId);
}
