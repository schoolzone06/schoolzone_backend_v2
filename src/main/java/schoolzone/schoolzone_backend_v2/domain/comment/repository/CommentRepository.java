package schoolzone.schoolzone_backend_v2.domain.comment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import schoolzone.schoolzone_backend_v2.domain.comment.domain.Comment;

public interface CommentRepository extends JpaRepository<Comment, Long> {

    Long countByPostId(Long postId);
}