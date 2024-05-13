package schoolzone.schoolzone_backend_v2.domain.post.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import schoolzone.schoolzone_backend_v2.domain.post.implementation.PostReader;
import schoolzone.schoolzone_backend_v2.domain.post.domain.Post;
import schoolzone.schoolzone_backend_v2.domain.post.domain.enums.Category;
import schoolzone.schoolzone_backend_v2.domain.post.presentation.dto.response.PostListResponseDto;

@Service
@RequiredArgsConstructor
public class QueryPostService {

    private final PostReader postReader;

    public Page<PostListResponseDto> findByCategory(Category category, int index, int count) {
        return postReader.findByCategory(category, index, count);
    }

    public Post findPostDetail(Long postId) {
        return postReader.findByPostId(postId);
    }
}
