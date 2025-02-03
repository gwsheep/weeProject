package com.jproject.weeService.repository;

import com.jproject.weeService.entity.NursingHome;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NursingHomeRepository extends JpaRepository<NursingHome, Long> {
}
