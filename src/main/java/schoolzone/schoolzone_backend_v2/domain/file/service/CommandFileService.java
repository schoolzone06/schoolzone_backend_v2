package schoolzone.schoolzone_backend_v2.domain.file.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import schoolzone.schoolzone_backend_v2.domain.file.implementation.FileCreator;

@Service
@Transactional
@RequiredArgsConstructor
public class CommandFileService {
    private final FileCreator fileCreator;

    public String create(MultipartFile file) {
        return fileCreator.upload(file);
    }
}
