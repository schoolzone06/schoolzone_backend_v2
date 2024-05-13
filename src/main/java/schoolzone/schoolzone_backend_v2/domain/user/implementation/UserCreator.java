package schoolzone.schoolzone_backend_v2.domain.user.implementation;

import lombok.RequiredArgsConstructor;
import schoolzone.schoolzone_backend_v2.domain.user.domain.User;
import schoolzone.schoolzone_backend_v2.domain.user.domain.repository.UserRepository;
import schoolzone.schoolzone_backend_v2.global.annotation.Implementation;

@Implementation
@RequiredArgsConstructor
public class UserCreator {

	private final UserRepository userRepository;

	public User createUserEntity(String email) {
		return User.createUnverifiedUser(email);
	}

	public User save(User user) {
		return userRepository.save(user);
	}
}
