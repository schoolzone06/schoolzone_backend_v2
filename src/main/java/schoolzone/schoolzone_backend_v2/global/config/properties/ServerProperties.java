package schoolzone.schoolzone_backend_v2.global.config.properties;

import lombok.Getter;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.nio.file.Path;

@Getter
@ConfigurationProperties(prefix = "server")
public class ServerProperties {
    private Path path;
    private String url;
}
