package com.jproject.weeService.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//RestController 기반으로 작성하기

@Slf4j
@RestController
@RequestMapping("/wee")
public class WeeController {

    @GetMapping("/main")
    public ResponseEntity<?> getMain() {
        log.info("Main Page requested");
        return ResponseEntity.ok("Main Page Response");
    }

    /* 각 기능을 완성되면 기능을 모듈화 하기 (MSA) */

}
