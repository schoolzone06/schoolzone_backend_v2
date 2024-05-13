package schoolzone.schoolzone_backend_v2.domain.user.presentation;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import schoolzone.schoolzone_backend_v2.domain.user.presentation.dto.request.UpdateUserRequestDto;
import schoolzone.schoolzone_backend_v2.domain.user.service.CommandUserService;
import schoolzone.schoolzone_backend_v2.global.security.util.SecurityUtil;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class CommandUserController {
    private final CommandUserService commandUserService;

    @PatchMapping
    public void updateNickname(@RequestBody UpdateUserRequestDto dto) {
        commandUserService.updateNickname(dto.nickname(), SecurityUtil.getUser());
    }
}
