package schoolzone.schoolzone_backend_v2.domain.file.implementation;

import lombok.RequiredArgsConstructor;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import schoolzone.schoolzone_backend_v2.global.annotation.Implementation;
import schoolzone.schoolzone_backend_v2.global.config.file.FileProperties;
import schoolzone.schoolzone_backend_v2.global.error.exception.ErrorCode;
import schoolzone.schoolzone_backend_v2.global.error.exception.SchoolzoneException;

import java.net.MalformedURLException;
import java.nio.file.Path;
import java.nio.file.Paths;

@Implementation
@RequiredArgsConstructor
public class FileReader {
    private final FileProperties fileProperties;

    public Resource loadFileAsResource(String fileName) {
        Path path = Paths.get(fileProperties.path() + fileName).normalize();
        try {
            Resource resource = new UrlResource(path.toUri());
            if (!resource.exists()) {
                return resource;
            } else {
                throw new SchoolzoneException(ErrorCode.FILE_NOT_FOUND);
            }
        } catch (MalformedURLException e) {
            throw new SchoolzoneException(ErrorCode.INVALID_URL_FORMAT);
        }
    }
}
