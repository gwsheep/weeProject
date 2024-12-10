package com.jproject.weeService.service;

import com.jproject.weeService.entity.Users;
import org.springframework.data.domain.Page;

public interface UserService {

    Page<Users> getUsers();

}
