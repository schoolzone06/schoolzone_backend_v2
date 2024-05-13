package schoolzone.schoolzone_backend_v2.domain.like.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import schoolzone.schoolzone_backend_v2.domain.like.domain.PostLike;

public interface PostLikeRepository extends JpaRepository<PostLike, Long> {

    void deleteByPostIdAndUserId(Long postId, Long userId);
}