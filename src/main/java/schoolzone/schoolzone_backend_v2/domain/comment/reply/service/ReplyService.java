package schoolzone.schoolzone_backend_v2.domain.comment.reply.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import schoolzone.schoolzone_backend_v2.domain.comment.reply.domain.Reply;
import schoolzone.schoolzone_backend_v2.domain.comment.reply.presentation.dto.request.ReplyCreateRequestDto;
import schoolzone.schoolzone_backend_v2.domain.comment.reply.presentation.dto.request.ReplyUpdateRequestDto;
import schoolzone.schoolzone_backend_v2.domain.comment.reply.service.implement.ReplyGetService;
import schoolzone.schoolzone_backend_v2.domain.comment.reply.service.implement.ReplySaveService;

@Service
@RequiredArgsConstructor
public class ReplyService {

    private final ReplyGetService replyGetService;
    private final ReplySaveService replySaveService;

    public Long create(ReplyCreateRequestDto dto) {
        return replySaveService.create(dto);
    }

    public Long update(Long id, ReplyUpdateRequestDto dto) {
        Reply reply = replyGetService.findByReplyId(id);
        return replySaveService.update(reply, dto);
    }
}
