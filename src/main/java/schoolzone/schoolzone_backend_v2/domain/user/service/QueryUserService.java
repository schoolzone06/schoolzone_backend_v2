package schoolzone.schoolzone_backend_v2.domain.user.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;
import schoolzone.schoolzone_backend_v2.domain.user.implementation.UserReader;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class QueryUserService {

	private final UserReader userReader;

	public Boolean checkNickname(String nickname) {
		return !userReader.existsByNickname(nickname);
	}
}
