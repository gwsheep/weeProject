package com.jproject.weeService.service;

import com.jproject.weeService.entity.Users;
import org.springframework.data.domain.Page;

import java.util.List;

public interface UserService {

    Page<Users> getUserList();

    List<Users> getUserListAll();

    Users getUserByUserId(String userId);

    String enrollUser(Users user);
    
    String updateUser(Users user);

}
