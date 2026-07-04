package org.learnspringframework.jobboard.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class InvalidJobDataException extends RuntimeException {
    public InvalidJobDataException(String message) {
        super(message);
    }
}
