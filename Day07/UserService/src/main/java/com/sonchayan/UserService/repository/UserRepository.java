package com.sonchayan.UserService.repository;

import com.sonchayan.UserService.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<UserEntity,Long> {
    UserEntity findByuserEmail(String userEmail);

    List<UserEntity> findAllByuserName(String userName);
}
