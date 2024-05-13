package schoolzone.schoolzone_backend_v2.domain.post.implementation;

import schoolzone.schoolzone_backend_v2.domain.post.domain.Post;
import schoolzone.schoolzone_backend_v2.global.annotation.Implementation;

@Implementation
public class PostUpdater {
    public void update(Post post, Post updatePost) {
        post.update(updatePost);
    }
}
