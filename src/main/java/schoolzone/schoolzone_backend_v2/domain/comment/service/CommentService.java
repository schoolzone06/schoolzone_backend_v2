package schoolzone.schoolzone_backend_v2.domain.comment.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import schoolzone.schoolzone_backend_v2.domain.comment.domain.Comment;
import schoolzone.schoolzone_backend_v2.domain.comment.presentation.dto.request.CommentCreateRequestDto;
import schoolzone.schoolzone_backend_v2.domain.comment.presentation.dto.request.CommentUpdateRequestDto;
import schoolzone.schoolzone_backend_v2.domain.comment.presentation.dto.response.CommentListResponseDto;
import schoolzone.schoolzone_backend_v2.domain.comment.service.implement.CommentGetService;
import schoolzone.schoolzone_backend_v2.domain.comment.service.implement.CommentSaveService;
import schoolzone.schoolzone_backend_v2.domain.comment.service.util.CommentUtil;
import schoolzone.schoolzone_backend_v2.domain.post.application.PostService;
import schoolzone.schoolzone_backend_v2.domain.user.service.UserService;

@Service
@RequiredArgsConstructor
public class CommentService {

    private final CommentGetService commentGetService;
    private final CommentSaveService commentSaveService;
    private final CommentUtil commentUtil;
    private final UserService userService;
    private final PostService postService;

    public Page<CommentListResponseDto> findByPostId(Long postId, int index, int count) {
        return commentGetService.findByPostId(postId, index, count);
    }

    public Comment findByCommentId(Long commentId) {
        return commentGetService.findByCommentId(commentId);
    }

    public Long create(CommentCreateRequestDto dto) {
        Long userId = userService.findCurrentUser().getId();
        Long postAuthorId = postService.findPostDetail(dto.postId()).getAuthorId();
        Long commentCount = commentUtil.commentCount(userId, dto.postId());
        String nickname = commentUtil.generateNickname(userId, postAuthorId, commentCount);

        return commentSaveService.create(userId, nickname, dto);
    }

    public Long update(Long commentId, CommentUpdateRequestDto dto) {
        Comment comment = commentGetService.findByCommentId(commentId);
        return commentSaveService.update(comment, dto);
    }

    public Long delete(Long commentId) {
        return commentSaveService.delete(commentId);
    }
}
