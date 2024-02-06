package schoolzone.schoolzone_backend_v2.domain.comment.like.presentation;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import schoolzone.schoolzone_backend_v2.domain.comment.like.service.CommentLikeService;

@RestController
@RequestMapping("/comment")
@RequiredArgsConstructor
public class CommentLikeController {

    private final CommentLikeService commentLikeService;

    @PostMapping("/{commentId}/like")
    public Long like(@PathVariable Long commentId) {
        return commentLikeService.like(commentId);
    }

    @DeleteMapping("/{commentId}/like")
    public Long cancelLike(@PathVariable Long commentId) {
        return commentLikeService.cancel(commentId);
    }
}
