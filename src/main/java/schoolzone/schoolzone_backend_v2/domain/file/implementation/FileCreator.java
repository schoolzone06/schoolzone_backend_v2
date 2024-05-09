package schoolzone.schoolzone_backend_v2.domain.file.implementation;

import lombok.RequiredArgsConstructor;
import org.springframework.web.multipart.MultipartFile;
import schoolzone.schoolzone_backend_v2.global.annotation.Implementation;
import schoolzone.schoolzone_backend_v2.global.config.file.FileProperties;
import schoolzone.schoolzone_backend_v2.global.error.exception.ErrorCode;
import schoolzone.schoolzone_backend_v2.global.error.exception.SchoolzoneException;

import java.io.IOException;
import java.nio.file.*;
import java.util.UUID;

@Implementation
@RequiredArgsConstructor
public class FileCreator {
    private final FileProperties fileProperties;

    public String uploadFile(MultipartFile file) {
        return fileProperties.serverUrl() + saveFile(file);
    }

    private String saveFile(MultipartFile file) {
        String filename = UUID.randomUUID() + file.getOriginalFilename();
        Path path = fileProperties.path().resolve(filename);
        try {
            Files.copy(file.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            throw new SchoolzoneException(ErrorCode.FILE_SAVE_ERROR);
        }
        return path.toString();
    }
}
