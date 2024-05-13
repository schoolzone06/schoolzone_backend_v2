package schoolzone.schoolzone_backend_v2.domain.user.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;
import schoolzone.schoolzone_backend_v2.domain.user.domain.User;
import schoolzone.schoolzone_backend_v2.domain.user.implementation.UserReader;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class QueryUserService {

	private final UserReader userReader;

	public boolean existsByEmail(String email) {
		return userReader.existsByEmail(email);
	}

	public User findById(Long id) {
		return userReader.findById(id);
	}

	public User findByEmail(String email) {
		return userReader.findByEmail(email);
	}
}
