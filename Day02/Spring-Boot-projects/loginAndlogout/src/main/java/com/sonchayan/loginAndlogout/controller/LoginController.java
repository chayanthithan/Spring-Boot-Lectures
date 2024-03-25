package com.sonchayan.loginAndlogout.controller;

import com.sonchayan.loginAndlogout.model.ResponseLogin;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.sonchayan.loginAndlogout.model.Login;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("/loginandLogout")
public class LoginController {

//    @PostMapping(value = "/login",consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
//    //http://localhost:8080/loginandLogout/login?username=chayan&password=123
//    public ResponseEntity<ResponseLogin> getLogin(@RequestParam String username,@RequestParam String password){
//        ResponseLogin responseLogin=new ResponseLogin();
//        responseLogin.setUsername(username);
//        responseLogin.setStatus("ok");
//        return new ResponseEntity<>(responseLogin, HttpStatus.OK);
//    }
//        @PostMapping(value = "/login",consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
//        //http://localhost:8080/loginandLogout/login?username=chayan&password=123
//        public ResponseEntity<ResponseLogin> getLogin(@RequestBody Login login){
//            ResponseLogin responseLogin=new ResponseLogin();
//            responseLogin.setUsername(login.getUsername());
//            responseLogin.setStatus("ok");
//            return new ResponseEntity<>(responseLogin, HttpStatus.OK);
//        }

        @GetMapping(value = "/login",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
        //doubt  can't we pass Login class here(instead of ResponseLogin)
        public ResponseEntity<ResponseLogin> loginMethod(@RequestParam String username,@RequestParam String password){
            ResponseLogin responseLogin=new ResponseLogin();
            responseLogin.setUsername(username);
            responseLogin.setStatus("ok");
            return new ResponseEntity<>(responseLogin, HttpStatus.OK);

        }
}
