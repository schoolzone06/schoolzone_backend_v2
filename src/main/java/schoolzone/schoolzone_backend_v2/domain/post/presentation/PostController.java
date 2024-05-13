package schoolzone.schoolzone_backend_v2.domain.post.presentation;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import schoolzone.schoolzone_backend_v2.domain.post.service.PostService;
import schoolzone.schoolzone_backend_v2.domain.post.domain.Post;
import schoolzone.schoolzone_backend_v2.domain.post.domain.enums.Category;
import schoolzone.schoolzone_backend_v2.domain.post.presentation.dto.request.PostCreateRequestDto;
import schoolzone.schoolzone_backend_v2.domain.post.presentation.dto.request.PostUpdateRequestDto;
import schoolzone.schoolzone_backend_v2.domain.post.presentation.dto.response.PostListResponseDto;

@RestController
@RequestMapping("/post")
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    @GetMapping
    public ResponseEntity<Page<PostListResponseDto>> findPostList(@RequestParam Category category,
                                                                  @RequestParam(required = false, defaultValue = "0") int index,
                                                                  @RequestParam int count) {
        return ResponseEntity.ok(postService.findByCategory(category, index, count));
    }

    @GetMapping("/{postId}")
    public ResponseEntity<Post> findPostDetail(@PathVariable Long postId) {
        return ResponseEntity.ok(postService.findPostDetail(postId));
    }

    @PostMapping
    public Long createPost(@RequestBody PostCreateRequestDto dto) {
        return postService.create(dto);
    }

    @PutMapping("/{postId}")
    public Long updatePost(@PathVariable Long postId,
                           @RequestBody PostUpdateRequestDto dto) {
        return postService.update(postId, dto);
    }

    @DeleteMapping("/{postId}")
    public Long deletePost(@PathVariable Long postId) {
        return postService.delete(postId);
    }
}
