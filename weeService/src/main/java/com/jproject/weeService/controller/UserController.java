package com.jproject.weeService.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.jproject.weeService.entity.Users;
import com.jproject.weeService.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.Option;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Slf4j
@RestController
@RequiredArgsConstructor
@Tag(name = "User Service", description = " ")
@RequestMapping("/wee/user")
public class UserController {

    private final UserService userService;

    @Operation(summary = "User list")
    @GetMapping("/list")
    public ResponseEntity<Page<?>> getUserList() {
        log.info("User list requested");

        //Page Interface
        Page<Users> userList = userService.getUserList();
        return ResponseEntity.status(HttpStatus.OK).body(userList);
    }

    @Operation(summary = "User list (Jackson test)")
    @GetMapping("/list/jackson")
    public ResponseEntity<String> getUserListWithJackson() {
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

        return ResponseEntity.status(HttpStatus.OK).body(userList.toString());
    }

    @Operation(summary = "User list (gson test)")
    @GetMapping("/list/gson")
    public ResponseEntity<String> getUserListWithGson() {
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

        return ResponseEntity.status(HttpStatus.OK).body(userObjectGson.toString());
    }

    @Operation(summary = "User Id")
    @GetMapping("/{userId}")
    public Users getUserById(@PathVariable("userId") String userId) {
        if(userId == null) {
            throw new NullPointerException("입력값이 없습니다");
        }
        return userService.getUserByUserId(userId);
    }

    @Operation(summary = "User 등록")
    @PostMapping("/enroll")
    public ResponseEntity<String> enrollUser(@RequestBody Users user) {
        log.info("User enroll requested");
        userService.enrollUser(user);
        return ResponseEntity.status(HttpStatus.OK).body("enroll complete");
    }

    @Operation(summary = "User 수정")
    @PostMapping("/edit")
    public ResponseEntity<String> editUser(@RequestBody Users user) {
        log.info("User edit requested");

        //exception 처리로 가능하면 따로 하기
        if(user == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }

        Users updatedUser = new Users();

        //예상 로직 (유효성 검사 Validator나 다른 방법으로 바꿔볼까 고민해보기)
        Optional.ofNullable(user).filter(e -> !e.getUserId().isEmpty()).map(Users::getUserId).ifPresent(updatedUser::setUserId);
        Optional.ofNullable(user).filter(e -> !e.getUserPw().isEmpty()).map(Users::getUserPw).ifPresent(updatedUser::setUserPw);
        Optional.ofNullable(user).filter(e -> !e.getUserName().isEmpty()).map(Users::getUserName).ifPresent(updatedUser::setUserName);

        userService.updateUser(updatedUser);

        return ResponseEntity.status(HttpStatus.OK).body("edit complete");
    }

    @Operation(summary = "User 삭제")
    @PostMapping("/delete")
    public ResponseEntity<String> deleteUser(@RequestBody Users user) {


        return ResponseEntity.status(HttpStatus.OK).body("delete complete");
    }


}