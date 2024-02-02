package schoolzone.schoolzone_backend_v2.domain.auth.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import schoolzone.schoolzone_backend_v2.domain.auth.domain.RefreshToken;

@Repository
public interface RefreshTokenRepository extends CrudRepository<RefreshToken, Long> {
}
