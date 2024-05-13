package schoolzone.schoolzone_backend_v2.domain.user.implementation;

import lombok.RequiredArgsConstructor;
import schoolzone.schoolzone_backend_v2.domain.user.domain.User;
import schoolzone.schoolzone_backend_v2.domain.user.domain.repository.UserRepository;
import schoolzone.schoolzone_backend_v2.global.annotation.Implementation;
import schoolzone.schoolzone_backend_v2.global.error.exception.ErrorCode;
import schoolzone.schoolzone_backend_v2.global.error.exception.SchoolzoneException;

@Implementation
@RequiredArgsConstructor
public class UserReader {

	private final UserRepository userRepository;

	public boolean existsByEmail(String email) {
		return userRepository.existsByEmail(email);
	}

	public User findById(Long id) {
		return userRepository.findById(id)
			.orElseThrow(() -> new SchoolzoneException(ErrorCode.USER_NOT_FOUND));
	}

	public User findByEmail(String email) {
		return userRepository.findByEmail(email)
			.orElseThrow(() -> new SchoolzoneException(ErrorCode.USER_NOT_FOUND));
	}

	public Boolean existsByNickname(String nickname) {
		return userRepository.existsByNickname(nickname);
	}
}
