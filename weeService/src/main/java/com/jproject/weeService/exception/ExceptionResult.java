package com.jproject.weeService.exception;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ExceptionResult {

    private String errorCode;
    private String errorMessage;

}
