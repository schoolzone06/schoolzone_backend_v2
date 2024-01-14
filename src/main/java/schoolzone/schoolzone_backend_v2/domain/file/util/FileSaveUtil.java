package schoolzone.schoolzone_backend_v2.domain.file.util;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
import schoolzone.schoolzone_backend_v2.global.config.properties.ServerProperties;
import schoolzone.schoolzone_backend_v2.global.error.exception.ErrorCode;
import schoolzone.schoolzone_backend_v2.global.error.exception.SchoolzoneException;

import java.io.IOException;
import java.nio.file.*;
import java.util.UUID;

@Component
@RequiredArgsConstructor
public class FileSaveUtil {
    private final ServerProperties serverProperties;

    public String save(MultipartFile file) {
        try {
            String fileName = UUID.randomUUID() + "_" + file.getOriginalFilename();
            Path path = serverProperties.getPath().resolve(
                    Paths.get(fileName)
                            .normalize());
            if (!Files.exists(serverProperties.getPath())) {
                Files.createDirectories(serverProperties.getPath());
            }
            Files.copy(file.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);
            return String.format("%s/%s", serverProperties.getPath(), fileName);
        } catch (IOException e) {
            throw new SchoolzoneException(ErrorCode.FILE_SAVE_ERROR);
        }
    }
}