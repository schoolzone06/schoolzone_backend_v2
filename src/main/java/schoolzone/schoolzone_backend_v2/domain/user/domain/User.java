package schoolzone.schoolzone_backend_v2.domain.user.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import schoolzone.schoolzone_backend_v2.domain.school.domain.School;
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

    @JoinColumn(name = "school_id")
    @ManyToOne(fetch = FetchType.EAGER)
    private School school;

    private Integer grade;

    private Integer classNumber;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Authority authority;

    public static User createUnverifiedUser(String email) {
        return User.builder()
                .email(email)
                .authority(Authority.UNVERIFIED_USER)
                .build();
    }

    public void verify() {
        this.authority = Authority.USER;
    }
}
