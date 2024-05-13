package schoolzone.schoolzone_backend_v2.domain.post.presentation;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import schoolzone.schoolzone_backend_v2.domain.post.service.QueryPostService;
import schoolzone.schoolzone_backend_v2.domain.post.domain.Post;
import schoolzone.schoolzone_backend_v2.domain.post.domain.enums.Category;
import schoolzone.schoolzone_backend_v2.domain.post.presentation.dto.response.PostListResponseDto;

@RestController
@RequestMapping("/post")
@RequiredArgsConstructor
public class QueryPostController {

    private final QueryPostService queryPostService;

    @GetMapping
    public ResponseEntity<Page<PostListResponseDto>> findPostList(@RequestParam Category category,
                                                                  @RequestParam(required = false, defaultValue = "0") int index,
                                                                  @RequestParam int count) {
        return ResponseEntity.ok(queryPostService.findByCategory(category, index, count));
    }

    @GetMapping("/{postId}")
    public ResponseEntity<Post> findPostDetail(@PathVariable Long postId) {
        return ResponseEntity.ok(queryPostService.findPostDetail(postId));
    }
}
