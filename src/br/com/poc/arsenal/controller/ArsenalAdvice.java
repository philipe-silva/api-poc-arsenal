package br.com.poc.arsenal.controller;

import br.com.poc.arsenal.exception.ArsenalException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ArsenalAdvice {

    @ResponseBody
    @ExceptionHandler(ArsenalException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String arsenalExceptionHandler(ArsenalException ex) {
        return ex.getMessage();
    }
}
