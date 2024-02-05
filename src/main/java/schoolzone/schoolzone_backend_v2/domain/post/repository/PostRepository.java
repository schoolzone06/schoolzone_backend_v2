package schoolzone.schoolzone_backend_v2.domain.post.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import schoolzone.schoolzone_backend_v2.domain.post.domain.Post;
import schoolzone.schoolzone_backend_v2.domain.post.domain.enums.Category;
import schoolzone.schoolzone_backend_v2.domain.post.presentation.dto.response.PostListResponseDto;

public interface PostRepository extends JpaRepository<Post, Long> {

    @Query(
            "SELECT p.id, p.title, p.content, p.createdAt, count(c), count(pl) " +
            "FROM Post p " +
                    "JOIN Comment c ON p.id = c.postId " +
                    "JOIN PostLike pl ON p.id = pl.postId " +
            "GROUP BY c.id, pl.id " +
            "ORDER BY p.id DESC "
    )
    Page<PostListResponseDto> findByCategory(Category category, Pageable pageable);
}