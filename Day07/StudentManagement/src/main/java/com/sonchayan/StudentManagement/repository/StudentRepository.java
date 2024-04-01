package com.sonchayan.StudentManagement.repository;

import com.sonchayan.StudentManagement.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student,Long> {
    Student findBystudentEmail(String studentEmail);
}
