package com.jproject.wee.service;

import com.jproject.wee.entity.User;
import org.springframework.data.domain.Page;

public interface UserService {

    Page<User> getUsers();

}
