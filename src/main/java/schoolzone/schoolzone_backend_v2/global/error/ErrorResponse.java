package schoolzone.schoolzone_backend_v2.global.error;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import schoolzone.schoolzone_backend_v2.global.error.exception.ErrorCode;
import schoolzone.schoolzone_backend_v2.global.error.exception.SchoolzoneException;

public record ErrorResponse(
        Integer status,
        String code,
        String message
) {
    @Override
    public String toString() {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return objectMapper.writeValueAsString(this);
        } catch (JsonProcessingException e) {
            throw new SchoolzoneException(ErrorCode.INTERNAL_SERVER_ERROR);
        }
    }
}
