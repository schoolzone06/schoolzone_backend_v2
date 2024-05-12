package schoolzone.schoolzone_backend_v2.global.config.file;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.bind.ConstructorBinding;

import java.nio.file.Path;
import java.nio.file.Paths;

@ConfigurationProperties(prefix = "file")
public record FileProperties(
    Path path,
    String serverUrl
) {
    @ConstructorBinding
    public FileProperties(String path, String serverUrl) {
        this(
                Paths.get(path),
                serverUrl
        );
    }
}
