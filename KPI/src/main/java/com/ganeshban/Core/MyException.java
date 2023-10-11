package com.ganeshban.Core;

import org.springframework.http.HttpStatus;

public class MyException extends Exception {
    String message;
    HttpStatus code;

    public MyException(String message) {

        super(message);
        this.message = message;
        this.code = HttpStatus.NOT_FOUND;
    }

    public MyException(String message, HttpStatus code) {
        super(message);
        this.message = message;
        this.code = code;
    }
}
