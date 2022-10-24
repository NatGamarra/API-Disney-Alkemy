package com.demo.exceptions;

public class BusinessException extends RuntimeException{

    private String code;
    private String status;

    public BusinessException(String message, String code, String status) {
        super(message);
        this.code = code;
        this.status = status;
    }
}
