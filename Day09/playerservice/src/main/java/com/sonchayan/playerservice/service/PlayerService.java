package com.sonchayan.playerservice.service;

import com.sonchayan.playerservice.model.Requestmodel;

public interface PlayerService {
    boolean registerPlayerDetails(Requestmodel requestmodel) throws Exception;

    boolean findPlayer(String playerEmail, String playerPassword) throws Exception;
}
