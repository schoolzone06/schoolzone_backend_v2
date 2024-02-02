package schoolzone.schoolzone_backend_v2.domain.post.application.implement;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import schoolzone.schoolzone_backend_v2.domain.post.domain.Post;
import schoolzone.schoolzone_backend_v2.domain.post.repository.PostRepository;

@Service
@RequiredArgsConstructor
@Transactional
public class PostSaveService {

    private final PostRepository postRepository;

    public Long create(Post post) {
        return postRepository.save(post).getId();
    }
}
