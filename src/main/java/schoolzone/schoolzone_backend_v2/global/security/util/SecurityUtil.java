package schoolzone.schoolzone_backend_v2.global.security.util;

import org.springframework.security.core.context.SecurityContextHolder;

import schoolzone.schoolzone_backend_v2.domain.user.domain.User;
import schoolzone.schoolzone_backend_v2.global.error.exception.ErrorCode;
import schoolzone.schoolzone_backend_v2.global.error.exception.SchoolzoneException;
import schoolzone.schoolzone_backend_v2.global.security.auth.AuthDetails;

public class SecurityUtil {

	private static User getUser() {

		Object principal = SecurityContextHolder.getContext()
			.getAuthentication()
			.getPrincipal();

		if (principal instanceof String) {
			throw new SchoolzoneException(ErrorCode.USER_NOT_FOUND);
		}

		AuthDetails authDetails = (AuthDetails) principal;

		return authDetails.getUser();
	}
}
