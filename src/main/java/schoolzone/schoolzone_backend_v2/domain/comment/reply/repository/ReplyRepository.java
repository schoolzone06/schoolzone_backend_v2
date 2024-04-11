package schoolzone.schoolzone_backend_v2.domain.comment.reply.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import schoolzone.schoolzone_backend_v2.domain.comment.reply.domain.Reply;
import schoolzone.schoolzone_backend_v2.domain.comment.reply.presentation.dto.response.ReplyListGetResponseDto;

import java.util.List;

public interface ReplyRepository extends JpaRepository<Reply, Long> {

    @Query(
            "select new schoolzone.schoolzone_backend_v2.domain.comment.reply.presentation.dto.response.ReplyListGetResponseDto( " +
                    "r.id, r.commentId, r.content, r.nickname, count(distinct rl.userId) " +
            ") " +
            "from Reply r " +
                    "left join ReplyLike rl on r.id = rl.replyId " +
            "where r.commentId = :commentId " +
            "group by r.id, r.commentId, r.content, r.nickname " +
            "order by r.id "
    )
    List<ReplyListGetResponseDto> findByCommentId(Long commentId);
}
