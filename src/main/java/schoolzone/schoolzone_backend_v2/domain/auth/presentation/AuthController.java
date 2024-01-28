package schoolzone.schoolzone_backend_v2.domain.auth.presentation;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import schoolzone.schoolzone_backend_v2.domain.auth.domain.Authentication;
import schoolzone.schoolzone_backend_v2.domain.auth.presentation.dto.request.StudentIDVerityRequestDto;
import schoolzone.schoolzone_backend_v2.domain.auth.presentation.dto.response.AuthLoginResponseDto;
import schoolzone.schoolzone_backend_v2.domain.auth.service.AuthService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
public class AuthController {

    private final AuthService authService;

    @GetMapping("/verify")
    public ResponseEntity<List<Authentication>> findAll() {
        return ResponseEntity.ok(authService.findVerifyRequest());
    }

    @PostMapping("/verify")
    public Long requestVerify(@RequestBody StudentIDVerityRequestDto dto) {
        return authService.saveVerifyRequest(dto);
    }

    @DeleteMapping("/verify/{id}")
    public Long verify(@PathVariable Long id) {
        return authService.verifyUser(id);
    }

    @PostMapping("/login/google")
    public AuthLoginResponseDto googleLogin(@RequestParam String code) {
        return authService.googleLogin(code);
    }

    // TODO: 1/28/24 logout / refresh token
}
