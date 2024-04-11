package schoolzone.schoolzone_backend_v2.domain.user.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import schoolzone.schoolzone_backend_v2.domain.user.domain.User;
import schoolzone.schoolzone_backend_v2.domain.user.repository.UserRepository;
import schoolzone.schoolzone_backend_v2.global.error.exception.ErrorCode;
import schoolzone.schoolzone_backend_v2.global.error.exception.SchoolzoneException;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    @Transactional(readOnly = true)
    public boolean isExistUser(String email) {
        return userRepository.existsByEmail(email);
    }

    @Transactional(readOnly = true)
    public User findById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new SchoolzoneException(ErrorCode.USER_NOT_FOUND));
    }

    @Transactional(readOnly = true)
    public User findByEmail(String email) {
        return userRepository.findByEmail(email)
                .orElseThrow(() -> new SchoolzoneException(ErrorCode.USER_NOT_FOUND));
    }

    @Transactional(readOnly = true)
    public User findCurrentUser() {
        return findByEmail(
                SecurityContextHolder.getContext().getAuthentication().getName()
        );
    }

    @Transactional
    public User createUser(String email) {
        return User.createUnverifiedUser(email);
    }

    @Transactional
    public Long saveUser(User user) {
        return userRepository.save(user).getId();
    }

    @Transactional
    public Long verify(Long userId) {
        return saveUser(findById(userId).verifyUser());
    }
}
