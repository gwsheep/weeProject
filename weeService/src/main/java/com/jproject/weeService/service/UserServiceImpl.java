package com.jproject.weeService.service;


import com.jproject.weeService.entity.Users;
import com.jproject.weeService.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public Page<Users> getUserList() {
        Sort sort = Sort.by(Sort.Direction.DESC, "id");
        Pageable pageable = PageRequest.of(0,30, sort);
        return userRepository.findAll(pageable);
    }

    @Override
    public List<Users> getUserListAll() {
        return userRepository.findAll();
    }

    @Override
    public Users getUserByUserId(String userId) {
        Users user = userRepository.findByUserId(userId);
        return user;
    }

    @Override
    public String enrollUser(Users user) {
        if(user == null) {
            return "user is null";
        }
        userRepository.save(user);
        return "user enrolled";
    }

    @Override
    public String updateUser(Users user) {
        userRepository.updateUsersByUserId(user.getUserId(), user);
        return "user updated";
    }


}
