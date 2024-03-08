package schoolzone.schoolzone_backend_v2.global.school.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "school")
public record SchoolProperties(
    String KEY,
    String Type,
    Integer pSize
) {
}
