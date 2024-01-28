package schoolzone.schoolzone_backend_v2.domain.auth.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import schoolzone.schoolzone_backend_v2.domain.auth.domain.Authentication;
import schoolzone.schoolzone_backend_v2.domain.auth.repository.AuthenticationRepository;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final AuthenticationRepository authenticationRepository;

    @Transactional
    public Long create(Authentication authentication) {
        return authenticationRepository.save(authentication).getId();
    }
}
