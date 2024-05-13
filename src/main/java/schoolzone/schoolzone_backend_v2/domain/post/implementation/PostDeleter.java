package schoolzone.schoolzone_backend_v2.domain.post.implementation;

import lombok.RequiredArgsConstructor;
import schoolzone.schoolzone_backend_v2.domain.post.domain.repository.PostRepository;
import schoolzone.schoolzone_backend_v2.global.annotation.Implementation;

@Implementation
@RequiredArgsConstructor
public class PostDeleter {
    private final PostRepository postRepository;

    public void deleteById(Long postId) {
        postRepository.deleteById(postId);
    }
}
