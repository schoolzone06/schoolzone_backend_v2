package schoolzone.schoolzone_backend_v2.domain.user.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;
import schoolzone.schoolzone_backend_v2.domain.user.domain.User;
import schoolzone.schoolzone_backend_v2.domain.user.implementation.UserCreator;
import schoolzone.schoolzone_backend_v2.domain.user.implementation.UserReader;
import schoolzone.schoolzone_backend_v2.domain.user.implementation.UserUpdater;

@Service
@Transactional
@RequiredArgsConstructor
public class CommandUserService {

    private final UserReader userReader;
    private final UserCreator userCreator;
    private final UserUpdater userUpdater;

    public Long save(User user) {
        return userCreator.save(user).getId();
    }

    public Long verify(Long userId) {
        User user = userReader.findById(userId);
        userUpdater.verify(user);
        return save(user);
    }
}
