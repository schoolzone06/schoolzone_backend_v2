package schoolzone.schoolzone_backend_v2.domain.auth.domain;

import jakarta.persistence.*;
import lombok.*;
import schoolzone.schoolzone_backend_v2.global.entity.BaseTimeEntity;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder
public class Authentication extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Long userId;

    @Column(nullable = false)
    private String studentIDCardUrl;
}
