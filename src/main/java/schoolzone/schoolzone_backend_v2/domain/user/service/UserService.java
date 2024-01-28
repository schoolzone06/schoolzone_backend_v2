package schoolzone.schoolzone_backend_v2.domain.user.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import schoolzone.schoolzone_backend_v2.domain.user.domain.User;
import schoolzone.schoolzone_backend_v2.domain.user.repository.UserRepository;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    @Transactional(readOnly = true)
    public boolean isExistUser(String email) {
        return userRepository.existsByEmail(email);
    }

    @Transactional
    public User createUser(String email) {
        return User.createUnverifiedUser(email);
    }

    @Transactional
    public Long saveUser(User user) {
        return userRepository.save(user).getId();
    }
}
