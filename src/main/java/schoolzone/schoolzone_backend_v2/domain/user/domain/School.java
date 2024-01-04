package schoolzone.schoolzone_backend_v2.domain.user.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Embeddable
@NoArgsConstructor
@AllArgsConstructor
public class School {

    @Column(nullable = false)
    private String schoolName;

    @Column(nullable = false)
    private Integer grade;

    @Column(nullable = false)
    private Integer classNumber;
}
