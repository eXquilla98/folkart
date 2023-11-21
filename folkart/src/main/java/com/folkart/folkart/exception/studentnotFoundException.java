package com.folkart.folkart.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class studentnotFoundException extends RuntimeException{

    private static final long serialVersionUID = 1L;
    public studentnotFoundException(String message){
           super(message);

    }
}
