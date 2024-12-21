package com.jproject.weeService.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class ExceptionResultAdvice {

    @ExceptionHandler(NullPointerException.class)
    public ResponseEntity<ExceptionResult> notParamException(NullPointerException e) {
        log.error("[NotParamException]", e);
        ExceptionResult exceptionResult = new ExceptionResult("No Params", e.getMessage());
        return new ResponseEntity<>(exceptionResult, HttpStatus.BAD_REQUEST);
    }

}
