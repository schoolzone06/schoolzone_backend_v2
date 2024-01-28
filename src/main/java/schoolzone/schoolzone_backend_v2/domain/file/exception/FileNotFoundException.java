package schoolzone.schoolzone_backend_v2.domain.file.exception;

import schoolzone.schoolzone_backend_v2.global.error.exception.ErrorCode;
import schoolzone.schoolzone_backend_v2.global.error.exception.SchoolzoneException;

public class FileNotFoundException extends SchoolzoneException {
    public static final SchoolzoneException EXCEPTION = new FileNotFoundException();
    public FileNotFoundException() {
        super(ErrorCode.FILE_NOT_FOUND);
    }
}
