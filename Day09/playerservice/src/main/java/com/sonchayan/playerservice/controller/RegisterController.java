package com.sonchayan.playerservice.controller;

import com.sonchayan.playerservice.model.Requestmodel;
import com.sonchayan.playerservice.model.ResponseModel;
import com.sonchayan.playerservice.service.PlayerService;
import lombok.extern.log4j.Log4j;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/player")
@Log4j2
public class RegisterController {
    @Autowired
    private PlayerService playerService;
    @PostMapping(value = "/register",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseModel> registerPlayerDetails(@RequestBody Requestmodel requestmodel) throws Exception{
        ResponseModel responseModel=new ResponseModel();
        //log.info("controller reached register  controller");
        boolean getvalue=playerService.registerPlayerDetails(requestmodel);
        if(getvalue){
            responseModel.setMsg("successfully registered!");
            responseModel.setStatus("OK");
            return new ResponseEntity<>(responseModel, HttpStatus.OK);
        }else{
            responseModel.setMsg("registered! was failure");
          //  log.warn("something went to wrong");
            responseModel.setStatus("OK");
            return new ResponseEntity<>(responseModel, HttpStatus.OK);
        }

    }
}
