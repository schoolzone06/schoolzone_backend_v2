package schoolzone.schoolzone_backend_v2.domain.school.service.client.dto.request;

public record SchoolInfoRequest(
        String KEY,
        String Type,
        Integer pIndex,
        Integer pSize
) {
}
