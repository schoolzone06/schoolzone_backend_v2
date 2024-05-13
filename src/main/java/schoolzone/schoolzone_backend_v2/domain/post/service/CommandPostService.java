package schoolzone.schoolzone_backend_v2.domain.post.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import schoolzone.schoolzone_backend_v2.domain.post.domain.Post;
import schoolzone.schoolzone_backend_v2.domain.post.implementation.*;

@Service
@Transactional
@RequiredArgsConstructor
public class CommandPostService {
    private final PostCreator postCreator;
    private final PostReader postReader;
    private final PostUpdater postUpdater;
    private final PostDeleter postDeleter;

    public void create(Post post) {
        postCreator.create(post);
    }

    public void update(Long postId, Post updatePost) {
        Post post = postReader.findByPostId(postId);
        postUpdater.update(post, updatePost);
    }

    public void delete(Long postId) {
        postDeleter.delete(postId);
    }
}
