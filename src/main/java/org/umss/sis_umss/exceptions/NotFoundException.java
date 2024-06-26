package org.umss.sis_umss.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class NotFoundException extends RuntimeException {
    public NotFoundException(String resourceName, String uuid) {
        super(String.format("NotFound: %s not found with uuid=%s", resourceName, uuid));
    }
}
