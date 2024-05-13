package schoolzone.schoolzone_backend_v2.domain.user.presentation;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import schoolzone.schoolzone_backend_v2.domain.user.service.QueryUserService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class QueryUserController {
    private final QueryUserService queryUserService;

    @GetMapping("/check/nickname")
    public ResponseEntity<Boolean> checkNickname(@RequestParam String nickname) {
        return ResponseEntity.ok(queryUserService.checkNickname(nickname));
    }
}
