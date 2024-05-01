package com.sonchayan.playerservice.controller;

import com.sonchayan.playerservice.errorHandler.WrongCredentialException;
import com.sonchayan.playerservice.model.ResponseModel;
import com.sonchayan.playerservice.service.PlayerService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/player")
@Slf4j
public class LoginController {
    @Autowired
    private PlayerService playerService;
    @PostMapping(value = "/login",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseModel> loginPlayer(@RequestParam String playerPassword,@RequestParam String playerEmail) throws Exception{
//    Logger logger=LoggerFactory.getLogger(LoginController.class);
//    logger.info("request reached loggincontroller");
        log.info("request reached loggincontroller");
       boolean getValue=playerService.findPlayer(playerEmail,playerPassword);
       ResponseModel rm=new ResponseModel();
        if(getValue){
            rm.setStatus("OK");
            rm.setMsg("successfully logined By "+playerEmail);
            //logger.debug("request successfully  debug");
            log.debug("request successfully  debug");
            return new ResponseEntity<>(rm, HttpStatus.OK);
        }else{
           throw new WrongCredentialException("wrong credential may be username or password or both wrong");
        }
    }
}
