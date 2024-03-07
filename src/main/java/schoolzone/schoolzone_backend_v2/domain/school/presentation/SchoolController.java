package schoolzone.schoolzone_backend_v2.domain.school.presentation;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import schoolzone.schoolzone_backend_v2.domain.school.service.SchoolService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/school")
public class SchoolController {

    private final SchoolService schoolService;

    @PostMapping
    public String execute() {
        return schoolService.execute();
    }
}
