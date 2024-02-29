package schoolzone.schoolzone_backend_v2.domain.comment.reply.like.presentation;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import schoolzone.schoolzone_backend_v2.domain.comment.reply.like.service.ReplyLikeService;

@RestController
@RequestMapping("/reply")
@RequiredArgsConstructor
public class ReplyLikeController {

    private final ReplyLikeService replyLikeService;

    @PostMapping("/{replyId}/like")
    @ResponseStatus(HttpStatus.CREATED)
    public Long replyLike(@PathVariable Long replyId) {
        return replyLikeService.like(replyId);
    }

    @DeleteMapping("/{replyId}/like")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void replyCancelLike(@PathVariable Long replyId) {
        replyLikeService.cancelLike(replyId);
    }
}
