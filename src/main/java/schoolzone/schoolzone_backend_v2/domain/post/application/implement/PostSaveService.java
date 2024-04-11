package schoolzone.schoolzone_backend_v2.domain.post.application.implement;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import schoolzone.schoolzone_backend_v2.domain.post.domain.Post;
import schoolzone.schoolzone_backend_v2.domain.post.presentation.dto.request.PostUpdateRequestDto;
import schoolzone.schoolzone_backend_v2.domain.post.repository.PostRepository;

@Service
@RequiredArgsConstructor
@Transactional
public class PostSaveService {

    private final PostRepository postRepository;

    private Post save(Post post) {
        return postRepository.save(post);
    }

    public Long create(Post post) {
        return save(post).getId();
    }

    public Long update(Post post, PostUpdateRequestDto dto) {
        return save(post.update(dto)).getId();
    }

    public Long delete(Long postId) {
        postRepository.deleteById(postId);
        return postId;
    }
}
