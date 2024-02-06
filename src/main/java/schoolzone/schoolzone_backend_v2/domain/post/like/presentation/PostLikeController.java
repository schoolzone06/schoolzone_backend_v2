package schoolzone.schoolzone_backend_v2.domain.post.like.presentation;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import schoolzone.schoolzone_backend_v2.domain.post.like.service.PostLikeService;

@RestController
@RequestMapping("/post")
@RequiredArgsConstructor
public class PostLikeController {

    private final PostLikeService postLikeService;

    @PostMapping("/{postId}/like")
    public Long like(@PathVariable Long postId) {
        return postLikeService.like(postId);
    }

    @DeleteMapping("/{postId}/like")
    public Long cancelLike(@PathVariable Long postId) {
        return postLikeService.cancel(postId);
    }
}
