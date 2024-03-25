package com.sonchayan.financeService.repository;

import com.sonchayan.financeService.entity.RegisterUserDetailsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoginRepository extends JpaRepository<RegisterUserDetailsEntity,Long> {
}
