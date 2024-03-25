package com.example.financeServiceDemo.repository;

import com.example.financeServiceDemo.entity.RegisterUserDetailsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<RegisterUserDetailsEntity,Long> {
}
