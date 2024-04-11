package schoolzone.schoolzone_backend_v2.domain.school.service.client.dto.response;

import java.util.List;

public record SchoolResponse(
        List<SchoolInfo> schoolInfo
) {
}
