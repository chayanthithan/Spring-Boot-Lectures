package com.sonchayan.playerservice.repository;

import com.sonchayan.playerservice.entity.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServiceRepository extends JpaRepository<Player,Long> {
    Player findByplayerEmail(String playerEmail);
}
