package schoolzone.schoolzone_backend_v2.global.security.auth;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import schoolzone.schoolzone_backend_v2.domain.user.domain.repository.UserRepository;
import schoolzone.schoolzone_backend_v2.global.error.exception.ErrorCode;
import schoolzone.schoolzone_backend_v2.global.error.exception.SchoolzoneException;

@Service
@RequiredArgsConstructor
public class AuthDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByEmail(username)
                .map(AuthDetails::new)
                .orElseThrow(() -> new SchoolzoneException(ErrorCode.USER_NOT_FOUND));
    }
}
