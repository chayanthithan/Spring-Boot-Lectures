package com.example.validationService.repository;

import com.example.validationService.entity.RegisterStudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<RegisterStudentEntity,Long> {
}
