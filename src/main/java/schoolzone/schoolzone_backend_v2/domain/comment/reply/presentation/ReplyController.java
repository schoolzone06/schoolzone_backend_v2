package schoolzone.schoolzone_backend_v2.domain.comment.reply.presentation;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import schoolzone.schoolzone_backend_v2.domain.comment.reply.presentation.dto.request.ReplyCreateRequestDto;
import schoolzone.schoolzone_backend_v2.domain.comment.reply.presentation.dto.request.ReplyUpdateRequestDto;
import schoolzone.schoolzone_backend_v2.domain.comment.reply.service.ReplyService;

@RestController
@RequestMapping("/reply")
@RequiredArgsConstructor
public class ReplyController {

    private final ReplyService replyService;

    @PostMapping
    public Long createReply(@RequestBody ReplyCreateRequestDto dto) {
        return replyService.create(dto);
    }

    @PutMapping("/{id}")
    public Long updateReply(@PathVariable Long id,
                            @RequestBody ReplyUpdateRequestDto dto) {
        return replyService.update(id, dto);
    }
}
