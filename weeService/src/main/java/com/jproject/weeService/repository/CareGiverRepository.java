package com.jproject.weeService.repository;

import com.jproject.weeService.entity.CareGiver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CareGiverRepository extends JpaRepository<CareGiver, Long> {
}
