package schoolzone.schoolzone_backend_v2.domain.file.service;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import schoolzone.schoolzone_backend_v2.domain.file.domain.File;
import schoolzone.schoolzone_backend_v2.domain.file.presentation.dto.response.FileResponse;
import schoolzone.schoolzone_backend_v2.domain.file.repository.FileRepository;
import schoolzone.schoolzone_backend_v2.domain.file.util.FileSaveUtil;
import schoolzone.schoolzone_backend_v2.global.config.properties.ServerProperties;

@Service
@RequiredArgsConstructor
public class PostFileService {
    private final FileRepository fileRepository;
    private final FileSaveUtil fileSaveUtil;
    private final ServerProperties serverProperties;

    public ResponseEntity<FileResponse> execute(MultipartFile file) {
        String path = fileSaveUtil.save(file);

        File saveFile = File.builder()
                .path(path)
                .build();
        fileRepository.save(saveFile);

        return ResponseEntity.ok(new FileResponse(serverProperties.getUrl() + "/file?id=" + saveFile.getId()));
    }
}
