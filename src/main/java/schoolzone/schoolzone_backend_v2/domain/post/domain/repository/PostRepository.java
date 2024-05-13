package schoolzone.schoolzone_backend_v2.domain.post.domain.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import schoolzone.schoolzone_backend_v2.domain.post.domain.Post;
import schoolzone.schoolzone_backend_v2.domain.post.domain.enums.Category;
import schoolzone.schoolzone_backend_v2.domain.post.presentation.dto.response.PostListResponseDto;

public interface PostRepository extends JpaRepository<Post, Long> {

    @Query(
            "SELECT new schoolzone.schoolzone_backend_v2.domain.post.presentation.dto.response.PostListResponseDto( " +
                    "p.id, p.title, p.content, p.createdAt, count(distinct pl.id), count(distinct c.id) " +
            ") " +
            "FROM Post p " +
                    "LEFT JOIN Comment c ON p.id = c.postId " +
                    "LEFT JOIN PostLike pl ON p.id = pl.postId " +
            "WHERE p.category = :category " +
            "GROUP BY p.id, p.title, p.content, p.createdAt " +
            "ORDER BY p.id DESC "
    )
    Page<PostListResponseDto> findByCategory(Category category, Pageable pageable);
}