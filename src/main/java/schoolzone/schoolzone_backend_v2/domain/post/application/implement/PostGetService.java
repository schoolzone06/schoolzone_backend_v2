package schoolzone.schoolzone_backend_v2.domain.post.application.implement;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import schoolzone.schoolzone_backend_v2.domain.post.domain.Post;
import schoolzone.schoolzone_backend_v2.domain.post.domain.enums.Category;
import schoolzone.schoolzone_backend_v2.domain.post.presentation.dto.response.PostListResponseDto;
import schoolzone.schoolzone_backend_v2.domain.post.repository.PostRepository;
import schoolzone.schoolzone_backend_v2.global.error.exception.ErrorCode;
import schoolzone.schoolzone_backend_v2.global.error.exception.SchoolzoneException;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class PostGetService {

    private final PostRepository postRepository;

    public Post findOne(Long postId) {
        return postRepository.findById(postId)
                .orElseThrow(() -> new SchoolzoneException(ErrorCode.POST_NOT_FOUND));
    }

    public Page<PostListResponseDto> findByCategory(Category category, int index, int count) {
        return postRepository.findByCategory(category, PageRequest.of(index, count));
    }
}
