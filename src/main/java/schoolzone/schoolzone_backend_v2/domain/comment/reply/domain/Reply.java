package schoolzone.schoolzone_backend_v2.domain.comment.reply.domain;

import jakarta.persistence.*;
import lombok.*;
import schoolzone.schoolzone_backend_v2.domain.comment.reply.presentation.dto.request.ReplyUpdateRequestDto;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder
public class Reply {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Long commentId;

    @Column(nullable = false)
    private Long userId;

    @Column(nullable = false)
    private String content;

    @Column(nullable = false)
    private String nickname;

    public Reply update(ReplyUpdateRequestDto dto) {
        this.content = dto.content();

        return this;
    }
}
