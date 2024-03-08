package schoolzone.schoolzone_backend_v2.domain.school.service.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(
        value = "SchoolInfoClient",
        url = "https://open.neis.go.kr/hub/schoolInfo"
)
public interface SchoolInfoClient {
    @GetMapping
    String getSchoolInfo(@RequestParam("KEY") String KEY,
                                 @RequestParam("Type") String Type,
                                 @RequestParam("pIndex") Integer pIndex,
                                 @RequestParam("pSize") Integer pSize);
}