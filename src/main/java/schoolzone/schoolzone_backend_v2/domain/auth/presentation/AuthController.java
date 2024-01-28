package schoolzone.schoolzone_backend_v2.domain.auth.presentation;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import schoolzone.schoolzone_backend_v2.domain.auth.presentation.dto.request.StudentIDVerityRequestDto;
import schoolzone.schoolzone_backend_v2.domain.auth.presentation.dto.response.AuthLoginResponseDto;
import schoolzone.schoolzone_backend_v2.domain.auth.service.AuthService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
public class AuthController {

    private final AuthService authService;

    // TODO: 1/28/24 verify StudentID (update account's state)
    @PostMapping("/verify")
    public Long requestVerify(@RequestBody StudentIDVerityRequestDto dto) {
        return authService.saveVerifyRequest(dto);
    }

    @PostMapping("/login/google")
    public AuthLoginResponseDto googleLogin(@RequestParam String code) {
        return authService.googleLogin(code);
    }

    // TODO: 1/28/24 logout / refresh token
}
