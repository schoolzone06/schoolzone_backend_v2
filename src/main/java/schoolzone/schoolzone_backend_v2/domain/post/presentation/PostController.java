package schoolzone.schoolzone_backend_v2.domain.post.presentation;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import schoolzone.schoolzone_backend_v2.domain.post.application.PostService;
import schoolzone.schoolzone_backend_v2.domain.post.presentation.dto.request.PostCreateRequestDto;
import schoolzone.schoolzone_backend_v2.domain.post.presentation.dto.request.PostUpdateRequestDto;

@RestController
@RequestMapping("/post")
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    @PostMapping
    public Long createPost(@RequestBody PostCreateRequestDto dto) {
        return postService.create(dto);
    }

    @PutMapping("/{postId}")
    public Long updatePost(@PathVariable Long postId,
                           @RequestBody PostUpdateRequestDto dto) {
        return postService.update(postId, dto);
    }
}
