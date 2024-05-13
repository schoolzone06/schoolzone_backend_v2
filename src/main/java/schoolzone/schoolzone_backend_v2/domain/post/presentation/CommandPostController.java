package schoolzone.schoolzone_backend_v2.domain.post.presentation;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import schoolzone.schoolzone_backend_v2.domain.post.presentation.dto.request.PostCreateRequestDto;
import schoolzone.schoolzone_backend_v2.domain.post.presentation.dto.request.PostUpdateRequestDto;
import schoolzone.schoolzone_backend_v2.domain.post.service.CommandPostService;
import schoolzone.schoolzone_backend_v2.global.security.util.SecurityUtil;

@RestController
@RequiredArgsConstructor
@RequestMapping("/post")
public class CommandPostController {

    private final CommandPostService commandPostService;

    @PostMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void create(@RequestBody PostCreateRequestDto dto) {
        commandPostService.create(dto.toEntity(SecurityUtil.getUser()));
    }

    @PutMapping("/{postId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update(@PathVariable Long postId,
                           @RequestBody PostUpdateRequestDto dto) {
        commandPostService.update(postId, dto.toEntity());
    }

    @DeleteMapping("/{postId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long postId) {
        commandPostService.delete(postId);
    }
}
