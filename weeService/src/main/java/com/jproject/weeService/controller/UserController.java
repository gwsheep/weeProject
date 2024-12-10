package com.jproject.weeService.controller;

import com.jproject.weeService.entity.Users;
import com.jproject.weeService.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/wee/user")
public class UserController {

    private final UserService userService;

    @GetMapping("/list")
    public ResponseEntity<Page<Users>> test() {
        return ResponseEntity.status(HttpStatus.OK).body(userService.getUsers());
    }

}

