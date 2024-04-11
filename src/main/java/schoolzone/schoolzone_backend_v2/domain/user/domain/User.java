package schoolzone.schoolzone_backend_v2.domain.user.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import schoolzone.schoolzone_backend_v2.global.entity.BaseTimeEntity;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class User extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String email;

    private String schoolName;

    private Integer grade;

    private Integer classNumber;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Authority authority;

    @Builder
    public User(String email, String schoolName, Integer grade, Integer classNumber, Authority authority) {
        this.email = email;
        this.schoolName = schoolName;
        this.grade = grade;
        this.classNumber = classNumber;
        this.authority = authority;
    }

    public static User createUnverifiedUser(String email) {
        return User.builder()
                .email(email)
                .authority(Authority.UNVERIFIED_USER)
                .build();
    }

    public User verifyUser() {
        this.authority = Authority.USER;

        return this;
    }
}
