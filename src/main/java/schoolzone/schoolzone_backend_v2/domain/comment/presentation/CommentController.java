package schoolzone.schoolzone_backend_v2.domain.comment.presentation;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import schoolzone.schoolzone_backend_v2.domain.comment.presentation.dto.request.CommentCreateRequestDto;
import schoolzone.schoolzone_backend_v2.domain.comment.presentation.dto.request.CommentUpdateRequestDto;
import schoolzone.schoolzone_backend_v2.domain.comment.service.CommentService;

@RestController
@RequestMapping("/comment")
@RequiredArgsConstructor
public class CommentController {

    private final CommentService commentService;

    @PostMapping
    public Long createComment(@RequestBody CommentCreateRequestDto dto) {
        return commentService.create(dto);
    }

    @PutMapping("/{commentId}")
    public Long updateComment(@PathVariable Long commentId,
                              @RequestBody CommentUpdateRequestDto dto) {
        return commentService.update(commentId, dto);
    }
}
