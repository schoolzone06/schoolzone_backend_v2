package schoolzone.schoolzone_backend_v2.domain.comment.reply.like.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import schoolzone.schoolzone_backend_v2.domain.comment.reply.like.domain.ReplyLike;
import schoolzone.schoolzone_backend_v2.domain.comment.reply.like.repository.ReplyLikeRepository;
import schoolzone.schoolzone_backend_v2.domain.user.service.UserService;

@Service
@RequiredArgsConstructor
@Transactional
public class ReplyLikeService {

    private final ReplyLikeRepository replyLikeRepository;
    private final UserService userService;

    public Long like(Long replyId) {
        Long userId = userService.findCurrentUser().getId();
        return replyLikeRepository.save(
                ReplyLike.builder()
                        .userId(userId)
                        .replyId(replyId)
                        .build()
        ).getId();
    }

    public void cancelLike(Long replyId) {
        replyLikeRepository.deleteByReplyId(replyId);
    }
}
