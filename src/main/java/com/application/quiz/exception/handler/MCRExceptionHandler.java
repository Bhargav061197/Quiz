package com.udaan.machine.exception.handler;

import com.udaan.machine.exception.MCRServiceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

public class MCRExceptionHandler {

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(value = {Exception.class})
    public final String handleAllExceptions(Exception ex) {
        return ex.getMessage();
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(value = {MCRServiceNotFoundException.class})
    public final String handleNotFoundException(Exception ex) {
        return ex.getMessage();
    }

}
