package com.testing.projectspring.error;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class ExistsDataException extends RuntimeException{

    public ExistsDataException(String message) {
        super(message);
    }
}
