package com.sonchayan.loginService.Controller;

import com.sonchayan.loginService.Model.RequestModel;
import com.sonchayan.loginService.Model.ResponseModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("login-service")
public class LoginController {
    //json
//    {
//        "username":"raam",
//            "password":123
//    }
//    @PostMapping(value = "/login", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
//    public ResponseEntity<ResponseModel> loginLogic(@RequestBody RequestModel input){
//        ResponseModel model=new ResponseModel();
//        model.setResult("ok");
//        model.setUsername(input.getUsername());
//        return new ResponseEntity<>(model, HttpStatus.CREATED);
//    }
//    http://localhost:8080/login-service/login?username=pirabu&password=123chayan
    //if i mentioned @RequestParam(required=false)  then we can access even without provide username
    @PostMapping(value = "/login", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseModel> loginLogic(@RequestParam(required = false) String username,@RequestParam String password){
        ResponseModel model=new ResponseModel();
        model.setResult("ok");
        model.setUsername(username);
        return new ResponseEntity<>(model, HttpStatus.CREATED);
    }
//    @GetMapping(value = "/login",produces = MediaType.APPLICATION_JSON_VALUE)
//    public ResponseEntity<ResponseModel> loginLogic(){
//        ResponseModel model=new ResponseModel();
//        model.setResult("ok");
//        model.setUsername("chayanKumar");
//        return new ResponseEntity<>(model,HttpStatus.CREATED);
//    }


}
