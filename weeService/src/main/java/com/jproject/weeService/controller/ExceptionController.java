package com.jproject.weeService.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequestMapping("/error")
public class ExceptionController {

    @GetMapping("/500")
    public String error500() {
        log.error("error 500 - INTERNAL SERVER ERROR");
        return "error/500";
    }

    @GetMapping("/404")
    public String error404() {
        log.error("error 404 - NOT FOUND");
        return "error/404";
    }


}
