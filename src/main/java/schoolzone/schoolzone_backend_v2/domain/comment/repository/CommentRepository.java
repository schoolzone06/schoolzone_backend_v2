package schoolzone.schoolzone_backend_v2.domain.comment.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import schoolzone.schoolzone_backend_v2.domain.comment.domain.Comment;
import schoolzone.schoolzone_backend_v2.domain.comment.presentation.dto.response.CommentListResponseDto;

public interface CommentRepository extends JpaRepository<Comment, Long> {

    @Query(
            "SELECT COUNT(c.id) " +
            "FROM Comment c " +
                    "LEFT JOIN Reply r ON c.id = r.commentId " +
            "WHERE " +
                    "c.postId = :postId " +
                    "AND " +
                    "c.userId != :authorId " +
            "GROUP BY c.id "
    )
    Long countByPostId(Long authorId, Long postId);

    @Query(
            "SELECT new schoolzone.schoolzone_backend_v2.domain.comment.presentation.dto.response.CommentListResponseDto( " +
                    "c.id, c.nickname, c.content, c.createdAt, count(cl.id), count(r.id) " +
            ") " +
            "FROM Comment c " +
                    "LEFT JOIN CommentLike cl ON c.id = cl.commentId " +
                    "LEFT JOIN Reply r ON c.id = r.commentId " +
            "WHERE c.postId = :postId " +
            "GROUP BY c.id, c.nickname, c.content, c.createdAt, cl.id, r.id " +
            "ORDER BY c.id DESC "
    )
    Page<CommentListResponseDto> findByPostId(Long postId, Pageable pageable);
}