package schoolzone.schoolzone_backend_v2.domain.school.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import schoolzone.schoolzone_backend_v2.domain.school.domain.School;
import schoolzone.schoolzone_backend_v2.domain.school.repository.SchoolRepository;
import schoolzone.schoolzone_backend_v2.domain.school.service.client.SchoolInfoClient;
import schoolzone.schoolzone_backend_v2.domain.school.service.client.dto.response.SchoolResponse;
import schoolzone.schoolzone_backend_v2.global.school.properties.SchoolProperties;

@Service
@RequiredArgsConstructor
public class SchoolService {

    private final SchoolInfoClient schoolInfoClient;
    private final SchoolProperties schoolProperties;
    private final ObjectMapper objectMapper;
    private final SchoolRepository schoolRepository;

    public String execute() {
        try {
            for (int i = 1; i < 100; i++) {
                SchoolResponse res = objectMapper.readValue(
                        schoolInfoClient.getSchoolInfo(
                                schoolProperties.KEY(),
                                schoolProperties.Type(),
                                i,
                                schoolProperties.pSize()), SchoolResponse.class);

                res.schoolInfo().get(1).row()
                        .forEach(schoolRow -> {
                            if (!schoolRepository.existsByName(schoolRow.SCHUL_NM()) && schoolRow.SCHUL_NM().isBlank() && schoolRow.ORG_RDNMA().isBlank()) {
                                schoolRepository.save(
                                        School.builder()
                                                .name(schoolRow.SCHUL_NM())
                                                .address(schoolRow.ORG_RDNMA())
                                                .build());
                            }});
            }
            return "s";
        } catch (Exception e) {
            return "e";
        }
    }
}
