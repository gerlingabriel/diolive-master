package com.dio.live.handler;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class notId extends RuntimeException {

    public notId(String message) {
        super(message);
    }

    
}
