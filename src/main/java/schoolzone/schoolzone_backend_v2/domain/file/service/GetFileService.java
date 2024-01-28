package schoolzone.schoolzone_backend_v2.domain.file.service;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import schoolzone.schoolzone_backend_v2.domain.file.domain.File;
import schoolzone.schoolzone_backend_v2.domain.file.exception.FileNotFoundException;
import schoolzone.schoolzone_backend_v2.domain.file.repository.FileRepository;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
@RequiredArgsConstructor
public class GetFileService {

    private final FileRepository fileRepository;

    public ResponseEntity<Resource> execute(Long fileId, HttpServletRequest httpServletRequest) throws IOException {
        File file = fileRepository.findById(fileId).orElseThrow(
                () -> FileNotFoundException.EXCEPTION
        );

        Path path = Paths.get(file.getPath());
        Resource resource = new UrlResource(path.toUri());
        String contentType = httpServletRequest.getServletContext().getMimeType(resource.getFile().getAbsolutePath());

        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(contentType))
                .header(contentType)
                .body(resource);
    }
}
