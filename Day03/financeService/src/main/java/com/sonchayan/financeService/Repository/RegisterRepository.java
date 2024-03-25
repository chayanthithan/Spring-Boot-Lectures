package com.sonchayan.financeService.Repository;

import com.sonchayan.financeService.Entity.RegisterUserDetailsEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RegisterRepository extends JpaRepository<RegisterUserDetailsEntity,Long> {
    //findById(Long user_id)
}
