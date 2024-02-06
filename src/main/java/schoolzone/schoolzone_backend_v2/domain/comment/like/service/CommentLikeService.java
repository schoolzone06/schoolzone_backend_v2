package schoolzone.schoolzone_backend_v2.domain.comment.like.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import schoolzone.schoolzone_backend_v2.domain.comment.like.domain.CommentLike;
import schoolzone.schoolzone_backend_v2.domain.comment.like.repository.CommentLikeRepository;
import schoolzone.schoolzone_backend_v2.domain.user.service.UserService;

@Service
@RequiredArgsConstructor
@Transactional
public class CommentLikeService {

    private final CommentLikeRepository commentLikeRepository;
    private final UserService userService;

    public Long like(Long commentId) {
        Long userId = userService.findCurrentUser().getId();
        return commentLikeRepository.save(
                CommentLike.builder()
                        .commentId(commentId)
                        .userId(userId)
                        .build()
        ).getId();
    }

    public Long cancel(Long commentId) {
        Long userId = userService.findCurrentUser().getId();
        commentLikeRepository.deleteByCommentIdAndUserId(commentId, userId);
        return commentId;
    }
}
