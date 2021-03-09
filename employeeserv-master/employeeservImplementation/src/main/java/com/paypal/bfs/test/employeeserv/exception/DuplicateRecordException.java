package com.paypal.bfs.test.employeeserv.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


@ResponseStatus(value = HttpStatus.UNPROCESSABLE_ENTITY)
public class DuplicateRecordException extends RuntimeException {

    private String errorMessage;

    public DuplicateRecordException() {

    }
    public DuplicateRecordException(String errorMessage) {
        super(errorMessage);
        this.errorMessage = errorMessage;
    }
    public String getErrorMessage() {
        return errorMessage;
    }

}