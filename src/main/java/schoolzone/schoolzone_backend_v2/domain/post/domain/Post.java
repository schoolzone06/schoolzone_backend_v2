package schoolzone.schoolzone_backend_v2.domain.post.domain;

import jakarta.persistence.*;
import lombok.*;
import schoolzone.schoolzone_backend_v2.domain.post.domain.enums.Category;
import schoolzone.schoolzone_backend_v2.domain.post.presentation.dto.request.PostUpdateRequestDto;
import schoolzone.schoolzone_backend_v2.domain.user.domain.User;
import schoolzone.schoolzone_backend_v2.global.entity.BaseTimeEntity;

@Builder
@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Post extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false, length = 5000)
    private String content;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Category category;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    public void update(Post post) {
        this.title = post.getTitle();
        this.content = post.getContent();
    }
}
