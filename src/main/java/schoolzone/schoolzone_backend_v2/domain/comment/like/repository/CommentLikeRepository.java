package schoolzone.schoolzone_backend_v2.domain.comment.like.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import schoolzone.schoolzone_backend_v2.domain.comment.like.domain.CommentLike;

public interface CommentLikeRepository extends JpaRepository<CommentLike, Long> {
}