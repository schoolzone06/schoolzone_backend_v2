package schoolzone.schoolzone_backend_v2.domain.comment.reply.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import schoolzone.schoolzone_backend_v2.domain.comment.reply.domain.Reply;

public interface ReplyRepository extends JpaRepository<Reply, Long> {
}
