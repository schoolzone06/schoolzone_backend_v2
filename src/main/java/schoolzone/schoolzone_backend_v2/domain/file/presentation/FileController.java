package schoolzone.schoolzone_backend_v2.domain.file.presentation;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import schoolzone.schoolzone_backend_v2.domain.file.presentation.dto.response.FileResponseDto;
import schoolzone.schoolzone_backend_v2.domain.file.presentation.dto.response.FileUrlResponseDto;
import schoolzone.schoolzone_backend_v2.domain.file.service.CommandFileService;
import schoolzone.schoolzone_backend_v2.domain.file.service.QueryFileService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/file")
public class FileController {
    private final CommandFileService commandFileService;
    private final QueryFileService queryFileService;

    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public FileUrlResponseDto postFile(@RequestPart(value = "file") MultipartFile file) {
        return FileUrlResponseDto.from(commandFileService.create(file));
    }

    @GetMapping("/{fileName}")
    public ResponseEntity<Resource> getFile(@PathVariable String fileName, HttpServletRequest request) {
        FileResponseDto dto = queryFileService.getFile(fileName, request);
        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(dto.contentType()))
                .header("Content-Type", dto.contentType())
                .body(dto.resource());
    }
}
