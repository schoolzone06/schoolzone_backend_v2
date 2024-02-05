package schoolzone.schoolzone_backend_v2.domain.comment.domain;

import jakarta.persistence.*;
import lombok.*;
import schoolzone.schoolzone_backend_v2.domain.comment.presentation.dto.request.CommentUpdateRequestDto;
import schoolzone.schoolzone_backend_v2.global.entity.BaseTimeEntity;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder
public class Comment extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Long postId;

    @Column(nullable = false)
    private Long userId;

    @Column(nullable = false)
    private String content;

    public Comment update(CommentUpdateRequestDto dto) {
        this.content = dto.content();

        return this;
    }
}
