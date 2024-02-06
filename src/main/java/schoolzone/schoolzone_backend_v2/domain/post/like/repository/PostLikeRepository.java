package schoolzone.schoolzone_backend_v2.domain.post.like.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import schoolzone.schoolzone_backend_v2.domain.post.like.domain.PostLike;

public interface PostLikeRepository extends JpaRepository<PostLike, Long> {

    void deleteByPostIdAndUserId(Long postId, Long userId);
}