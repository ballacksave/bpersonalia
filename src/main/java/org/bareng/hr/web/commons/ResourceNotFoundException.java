package org.bareng.hr.web.commons;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Just an "marker" exception, when this exception thrown from inside any
 * handler-method, exception-handling mechanism of mvc will "translate" to
 * response with 404 http status code.
 * 
 * @author zakyalvan
 */
@SuppressWarnings("serial")
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException {
}
