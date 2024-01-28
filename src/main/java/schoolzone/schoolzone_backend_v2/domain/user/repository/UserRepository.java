package schoolzone.schoolzone_backend_v2.domain.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import schoolzone.schoolzone_backend_v2.domain.user.domain.User;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByEmail(String phoneNumber);

    boolean existsByEmail(String email);
}
