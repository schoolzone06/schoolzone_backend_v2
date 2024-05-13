package schoolzone.schoolzone_backend_v2.domain.file.presentation.dto.response;

public record FileUrlResponseDto(
    String url
) {
    public static FileUrlResponseDto from(String url) {
        return new FileUrlResponseDto(url);
    }
}
