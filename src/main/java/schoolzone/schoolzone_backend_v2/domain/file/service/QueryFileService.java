package schoolzone.schoolzone_backend_v2.domain.file.service;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import schoolzone.schoolzone_backend_v2.domain.file.implementation.FileReader;
import schoolzone.schoolzone_backend_v2.domain.file.presentation.dto.response.FileResponseDto;

import java.io.IOException;

@Service
@RequiredArgsConstructor
public class QueryFileService {
    private final FileReader fileReader;

    public FileResponseDto getFile(String fileName, HttpServletRequest request) {
        Resource resource = fileReader.loadFileAsResource(fileName);
        String contentType = getContentType(resource, request);
        return new FileResponseDto(resource, contentType);
    }

    private String getContentType(Resource resource, HttpServletRequest request) {
        String contentType = "application/octet-stream";
        try {
            String mimeType = request.getServletContext().getMimeType(resource.getFile().getAbsolutePath());
            if (mimeType != null) {
                contentType = mimeType;
            }
        }
        catch (IOException ignored) {
        }
        return contentType;
    }

}
