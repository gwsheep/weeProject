package com.jproject.weeService.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

//RestController 기반으로 작성하기

@Slf4j
@Controller
@RequestMapping("/wee")
public class WeeController {

    @GetMapping("/main")
    public String getMain() {
        log.info("Main Page requested");
        return "mainPage";
    }



}
