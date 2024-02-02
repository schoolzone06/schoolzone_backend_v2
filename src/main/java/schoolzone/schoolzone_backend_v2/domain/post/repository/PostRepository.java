package schoolzone.schoolzone_backend_v2.domain.post.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import schoolzone.schoolzone_backend_v2.domain.post.domain.Post;

public interface PostRepository extends JpaRepository<Post, Long> {
}