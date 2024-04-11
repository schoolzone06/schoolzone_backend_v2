package schoolzone.schoolzone_backend_v2.domain.file.presentation;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import schoolzone.schoolzone_backend_v2.domain.file.presentation.dto.response.FileResponse;
import schoolzone.schoolzone_backend_v2.domain.file.service.GetFileService;
import schoolzone.schoolzone_backend_v2.domain.file.service.PostFileService;

import java.io.IOException;

@RestController
@RequiredArgsConstructor
@RequestMapping("/file")
public class FileController {
    private final PostFileService postFileService;
    private final GetFileService getFileService;

    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<FileResponse> postFile(@RequestPart(value = "file") MultipartFile file) {
        return postFileService.execute(file);
    }

    @GetMapping
    public ResponseEntity<Resource> getFile(@RequestParam Long fileId, HttpServletRequest httpServletRequest) throws IOException {
        return getFileService.execute(fileId, httpServletRequest);
    }
}
