package schoolzone.schoolzone_backend_v2.domain.comment.reply.service.implement;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import schoolzone.schoolzone_backend_v2.domain.comment.reply.domain.Reply;
import schoolzone.schoolzone_backend_v2.domain.comment.reply.presentation.dto.request.ReplyCreateRequestDto;
import schoolzone.schoolzone_backend_v2.domain.comment.reply.presentation.dto.request.ReplyUpdateRequestDto;
import schoolzone.schoolzone_backend_v2.domain.comment.reply.repository.ReplyRepository;
import schoolzone.schoolzone_backend_v2.domain.comment.service.CommentService;
import schoolzone.schoolzone_backend_v2.domain.comment.service.util.CommentUtil;
import schoolzone.schoolzone_backend_v2.domain.post.application.PostService;
import schoolzone.schoolzone_backend_v2.domain.user.service.UserService;

@Service
@RequiredArgsConstructor
@Transactional
public class ReplySaveService {

    private final ReplyRepository replyRepository;
    private final UserService userService;
    private final CommentService commentService;
    private final CommentUtil commentUtil;
    private final PostService postService;

    public Long create(ReplyCreateRequestDto dto) {
        Long userId = userService.findCurrentUser().getId();
        Long postId = commentService.findByCommentId(dto.commentId()).getPostId();
        Long postAuthorId = postService.findPostDetail(postId).getAuthorId();
        Long commentCount = commentUtil.commentCount(userId, postId);
        String nickname = commentUtil.generateNickname(userId, postAuthorId, commentCount);
        return save(dto.toEntity(userId, nickname)).getId();
    }

    public Long update(Reply reply, ReplyUpdateRequestDto dto) {
        return save(reply.update(dto)).getId();
    }

    public Long delete(Long id) {
        replyRepository.deleteById(id);
        return id;
    }

    private Reply save(Reply reply) {
        return replyRepository.save(reply);
    }
}
