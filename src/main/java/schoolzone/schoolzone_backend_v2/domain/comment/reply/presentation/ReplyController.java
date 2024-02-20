package schoolzone.schoolzone_backend_v2.domain.comment.reply.presentation;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import schoolzone.schoolzone_backend_v2.domain.comment.reply.domain.Reply;
import schoolzone.schoolzone_backend_v2.domain.comment.reply.presentation.dto.request.ReplyCreateRequestDto;
import schoolzone.schoolzone_backend_v2.domain.comment.reply.presentation.dto.request.ReplyUpdateRequestDto;
import schoolzone.schoolzone_backend_v2.domain.comment.reply.service.ReplyService;

import java.util.List;

@RestController
@RequestMapping("/reply")
@RequiredArgsConstructor
public class ReplyController {

    private final ReplyService replyService;

    @GetMapping("/{commentId}")
    public ResponseEntity<List<Reply>> findByCommentId(@PathVariable Long commentId) {
        return ResponseEntity.ok(replyService.findByCommentId(commentId));
    }

    @PostMapping
    public Long createReply(@RequestBody ReplyCreateRequestDto dto) {
        return replyService.create(dto);
    }

    @PutMapping("/{id}")
    public Long updateReply(@PathVariable Long id,
                            @RequestBody ReplyUpdateRequestDto dto) {
        return replyService.update(id, dto);
    }

    @DeleteMapping("/{id}")
    public Long deleteReply(@PathVariable Long id) {
        return replyService.delete(id);
    }
}
