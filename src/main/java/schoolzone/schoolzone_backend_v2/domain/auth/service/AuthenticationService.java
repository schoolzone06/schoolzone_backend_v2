package schoolzone.schoolzone_backend_v2.domain.auth.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import schoolzone.schoolzone_backend_v2.domain.auth.domain.Authentication;
import schoolzone.schoolzone_backend_v2.domain.auth.repository.AuthenticationRepository;
import schoolzone.schoolzone_backend_v2.global.error.exception.ErrorCode;
import schoolzone.schoolzone_backend_v2.global.error.exception.SchoolzoneException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final AuthenticationRepository authenticationRepository;

    @Transactional(readOnly = true)
    public List<Authentication> findAll() {
        return authenticationRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Authentication findById(Long id) {
        return authenticationRepository.findById(id)
                .orElseThrow(() -> new SchoolzoneException(ErrorCode.AUTHENTICATION_NOT_FOUND));
    }

    @Transactional
    public Long create(Authentication authentication) {
        return authenticationRepository.save(authentication).getId();
    }

    @Transactional
    public void delete(Long id) {
        authenticationRepository.deleteById(id);
    }
}
