package schoolzone.schoolzone_backend_v2.domain.post.presentation;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import schoolzone.schoolzone_backend_v2.domain.post.application.PostService;
import schoolzone.schoolzone_backend_v2.domain.post.presentation.dto.request.PostCreateRequestDto;

@RestController
@RequestMapping("/post")
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    @PostMapping
    public Long createPost(@RequestBody PostCreateRequestDto dto) {
        return postService.create(dto);
    }
}
