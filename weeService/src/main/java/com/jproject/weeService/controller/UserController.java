package com.jproject.weeService.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.jproject.weeService.entity.Users;
import com.jproject.weeService.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/wee/user")
public class UserController {

    private final UserService userService;

    @GetMapping("/list")
    public ResponseEntity<Page<?>> getUserList() {
        log.info("User list requested");

        //Page Interface
        Page<Users> userList = userService.getUserList();
        return ResponseEntity.status(HttpStatus.OK).body(userList);
    }

    @GetMapping("/jackson")
    public ResponseEntity<String> getUserJackson() {
        log.info("User list requested");

        //Json(Jackson) serialization(객체 -> JSON)
        ObjectMapper objectMapper = new ObjectMapper();
        List<Users> userList = userService.getUserListAll();

        String users = "";
        try {
            //객체 -> String
            users = objectMapper.writeValueAsString(userList);
            System.out.println("users = " + users);

            //객체 -> byte[]
            byte[] usersBytes = objectMapper.writeValueAsBytes(userList);
            System.out.println("userBytes" + usersBytes);
            System.out.println("userBytes for String " + new String(usersBytes));

            //String -> 객체
            List<Users> userListCheck = objectMapper.readValue(users, new TypeReference<>(){});
            System.out.println("userListCheck = " + userListCheck);

            //byte[] -> 객체
            List<Users> userBytesCheck = objectMapper.readValue(usersBytes, new TypeReference<>(){});
            System.out.println("userBytesCheck = " + userBytesCheck);


        } catch (IOException e) {
            e.printStackTrace();
        }

        return ResponseEntity.status(HttpStatus.OK).body(users);
    }

    @GetMapping("/gson")
    public ResponseEntity<String> getUserGson() {
        log.info("User list requested");

        //Json(Gson) serialization(객체 -> JSON)
        Gson gson = new Gson();
        List<Users> userList = userService.getUserListAll();

        //객체 -> String
        String userStringGson = gson.toJson(userList);
        System.out.println("userStringGson = " + userStringGson);

        //String -> 객체
        String jsonInput = "{\"id\":\"201\",\"userId\":\"test1\"}";
        Users userObjectGson = gson.fromJson(jsonInput, Users.class);
        System.out.println("userObjectGson = " + userObjectGson);

        return ResponseEntity.status(HttpStatus.OK).body("complete");
    }


        @GetMapping("/{userId}")
    public Users getUserById(@PathVariable("userId") String userId) {
        if(userId.equals("null")) {
            throw new NullPointerException("입력값이 없습니다");
        }
        return userService.getUserByUserId(userId);
    }

    @PostMapping("/enroll")
    public ResponseEntity<String> enrollUser(@RequestBody Users user) {
        log.info("User enroll requested");




        return ResponseEntity.status(HttpStatus.OK).body("enroll complete");
    }


}

