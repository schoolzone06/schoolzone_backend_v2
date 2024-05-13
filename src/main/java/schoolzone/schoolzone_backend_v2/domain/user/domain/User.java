package schoolzone.schoolzone_backend_v2.domain.user.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import schoolzone.schoolzone_backend_v2.domain.school.domain.School;
import schoolzone.schoolzone_backend_v2.domain.user.domain.enums.Authority;
import schoolzone.schoolzone_backend_v2.global.entity.BaseTimeEntity;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class User extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false, unique = true)
    private String nickname;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Authority authority;

    @JoinColumn(name = "school_id")
    @ManyToOne(fetch = FetchType.EAGER)
    private School school;

    public void updateNickname(String nickname) {
        this.nickname = nickname;
    }
}
