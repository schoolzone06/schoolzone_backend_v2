package schoolzone.schoolzone_backend_v2.domain.user.domain;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Embeddable
@NoArgsConstructor
@AllArgsConstructor
public class School {

    private String schoolName;

    private Integer grade;

    private Integer classNumber;
}
