package schoolzone.schoolzone_backend_v2.domain.post.like.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import schoolzone.schoolzone_backend_v2.domain.post.like.domain.PostLike;
import schoolzone.schoolzone_backend_v2.domain.post.like.repository.PostLikeRepository;
import schoolzone.schoolzone_backend_v2.domain.user.service.UserService;

@Service
@RequiredArgsConstructor
@Transactional
public class PostLikeService {

    private final PostLikeRepository postLikeRepository;
    private final UserService userService;

    public Long like(Long postId) {
        Long userId = userService.findCurrentUser().getId();
        return postLikeRepository.save(
                PostLike.builder()
                        .postId(postId)
                        .userId(userId)
                        .build()
        ).getId();
    }

    public Long cancel(Long postId) {
        Long userId = userService.findCurrentUser().getId();
        postLikeRepository.deleteByPostIdAndUserId(postId, userId);
        return postId;
    }
}
