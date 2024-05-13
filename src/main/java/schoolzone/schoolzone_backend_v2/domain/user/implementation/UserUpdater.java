package schoolzone.schoolzone_backend_v2.domain.user.implementation;

import schoolzone.schoolzone_backend_v2.domain.user.domain.User;
import schoolzone.schoolzone_backend_v2.global.annotation.Implementation;

@Implementation
public class UserUpdater {

	public void updateNickname(User user, String nickname) {
		user.updateNickname(nickname);
	}
}
