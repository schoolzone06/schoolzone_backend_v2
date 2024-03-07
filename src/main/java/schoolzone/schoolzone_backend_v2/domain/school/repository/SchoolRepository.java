package schoolzone.schoolzone_backend_v2.domain.school.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import schoolzone.schoolzone_backend_v2.domain.school.domain.School;

@Repository
public interface SchoolRepository extends JpaRepository<School, Long> {
    boolean existsByName(String name);
}
