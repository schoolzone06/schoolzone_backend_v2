package schoolzone.schoolzone_backend_v2.domain.comment.presentation;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import schoolzone.schoolzone_backend_v2.domain.comment.presentation.dto.request.CommentCreateRequestDto;
import schoolzone.schoolzone_backend_v2.domain.comment.presentation.dto.request.CommentUpdateRequestDto;
import schoolzone.schoolzone_backend_v2.domain.comment.presentation.dto.response.CommentListResponseDto;
import schoolzone.schoolzone_backend_v2.domain.comment.service.CommentService;

@RestController
@RequestMapping("/comment")
@RequiredArgsConstructor
public class CommentController {

    private final CommentService commentService;

    @GetMapping
    public ResponseEntity<Page<CommentListResponseDto>> findByPostId(@RequestParam Long postId,
                                                                     @RequestParam(required = false, defaultValue = "0") int index,
                                                                     @RequestParam int count) {
        return ResponseEntity.ok(commentService.findByPostId(postId, index, count));
    }

    @PostMapping
    public Long createComment(@RequestBody CommentCreateRequestDto dto) {
        return commentService.create(dto);
    }

    @PutMapping("/{commentId}")
    public Long updateComment(@PathVariable Long commentId,
                              @RequestBody CommentUpdateRequestDto dto) {
        return commentService.update(commentId, dto);
    }

    @DeleteMapping("/{commentId}")
    public Long deleteComment(@PathVariable Long commentId) {
        return commentService.delete(commentId);
    }
}
