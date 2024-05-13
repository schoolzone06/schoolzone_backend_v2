package schoolzone.schoolzone_backend_v2.domain.post.implementation;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import schoolzone.schoolzone_backend_v2.domain.post.domain.Post;
import schoolzone.schoolzone_backend_v2.domain.post.domain.enums.Category;
import schoolzone.schoolzone_backend_v2.domain.post.presentation.dto.response.PostListResponseDto;
import schoolzone.schoolzone_backend_v2.domain.post.domain.repository.PostRepository;
import schoolzone.schoolzone_backend_v2.global.annotation.Implementation;
import schoolzone.schoolzone_backend_v2.global.error.exception.ErrorCode;
import schoolzone.schoolzone_backend_v2.global.error.exception.SchoolzoneException;

@Implementation
@RequiredArgsConstructor
public class PostReader {

    private final PostRepository postRepository;

    public Post findByPostId(Long postId) {
        return postRepository.findById(postId)
                .orElseThrow(() -> new SchoolzoneException(ErrorCode.POST_NOT_FOUND));
    }

    public Page<PostListResponseDto> findByCategory(Category category, int index, int count) {
        return postRepository.findByCategory(category, PageRequest.of(index, count));
    }
}
