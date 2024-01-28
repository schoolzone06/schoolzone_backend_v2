package schoolzone.schoolzone_backend_v2.domain.auth.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import schoolzone.schoolzone_backend_v2.domain.auth.domain.Authentication;

public interface AuthenticationRepository extends JpaRepository<Authentication, Long> {
}
