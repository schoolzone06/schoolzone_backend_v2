package schoolzone.schoolzone_backend_v2.domain.file.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import schoolzone.schoolzone_backend_v2.domain.file.domain.File;

@Repository
public interface FileRepository extends JpaRepository<File, Long> {
}
