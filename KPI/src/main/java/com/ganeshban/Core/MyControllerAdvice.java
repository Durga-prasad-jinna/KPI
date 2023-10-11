package com.ganeshban.Core;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class MyControllerAdvice {
    @ExceptionHandler(MyException.class)
    public ResponseEntity<String> notFound(MyException myException) {
        return new ResponseEntity<>(myException.getMessage(), HttpStatus.NOT_FOUND);
    }
}
