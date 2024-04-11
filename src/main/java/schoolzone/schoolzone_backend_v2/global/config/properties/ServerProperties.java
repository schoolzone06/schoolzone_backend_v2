package schoolzone.schoolzone_backend_v2.global.config.properties;

import lombok.Getter;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.nio.file.Path;
import java.nio.file.Paths;

@Getter
@ConfigurationProperties(prefix = "server")
public class ServerProperties {
    private final Path path;
    private final String url;

    public ServerProperties(String path, String url) {
        this.path = Paths.get(path);
        this.url = url;
    }
}
