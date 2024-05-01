package com.sonchayan.playerservice.service.impl;

import com.sonchayan.playerservice.entity.Player;
import com.sonchayan.playerservice.errorHandler.NullPointerException;
import com.sonchayan.playerservice.errorHandler.UserNotFoundException;
import com.sonchayan.playerservice.model.Requestmodel;
import com.sonchayan.playerservice.repository.ServiceRepository;
import com.sonchayan.playerservice.service.PlayerService;
import lombok.extern.log4j.Log4j2;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Log4j2
public class PlayerServiceImpl implements PlayerService {
    @Autowired
    private ServiceRepository repository;

    @Override
    public boolean registerPlayerDetails(Requestmodel requestmodel) throws Exception{
//        log.info("request reaached service impl");
//        Logger logger= LoggerFactory.getLogger(PlayerServiceImpl.class);
////logger
//        logger.info("service impl reached info level log");
//        logger.debug("service impl reached debug level log");
        Player player=new Player();
        player.setPlayerCountry(requestmodel.getPlayerCountry());
        player.setPlayerEmail(requestmodel.getPlayerEmail());
        player.setPlayerName(requestmodel.getPlayerName());
        player.setPlayerPassword(requestmodel.getPlayerPassword());
        player.setPlayerNum(requestmodel.getPlayerNum());
        Optional<Player> player2= Optional.of(repository.save(player));
        if(player2.isPresent()){
            return true;
        }else{
            throw new NullPointerException("null pointer Exception");
        }

    }

    @Override
    public boolean findPlayer(String playerEmail, String playerPassword) throws Exception{
        Optional<Player> player= Optional.ofNullable(repository.findByplayerEmail(playerEmail));
       log.debug("this is logging serviceimpl debug succesfull");
        if(player.isPresent()){
            if(player.get().getPlayerPassword().equals(playerPassword)){
                return true;
            }else{
                throw new UserNotFoundException("user not found");
            }
        }else{
            throw new NullPointerException("null pointer exception /invalid email");
        }

    }
}
