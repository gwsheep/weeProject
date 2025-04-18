package com.jproject.weeService.repository;

import com.jproject.weeService.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<Users, Long> {

    Users findByUserId(String userId);

    Users updateUsersByUserId(String userId, Users users);

}
