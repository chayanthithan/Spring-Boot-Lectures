package com.example.HospitalService.exceptionHandler;

import com.example.HospitalService.model.ErrorResponseModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@RestController
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
    //user not found exception class
    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<Object> UserNotFoundExceptionHandler(UserNotFoundException ex, WebRequest wr){
        ErrorResponseModel erm=new ErrorResponseModel();
        erm.setErrorMessage(ex.getMessage());
        return new ResponseEntity<>(erm, HttpStatus.OK);
    }
//null pointer exception class it is return an obeject
    @ExceptionHandler(NullPointerException.class)
    public ResponseEntity<Object> NullPointerExceptionHandler(NullPointerException ex, WebRequest wr){
        ErrorResponseModel erm=new ErrorResponseModel();
        erm.setErrorMessage(ex.getMessage());
        return new ResponseEntity<>(erm, HttpStatus.OK);
    }
//credential not matched exception class it is return an object
    @ExceptionHandler(CredentialNotMatchedException.class)
    public ResponseEntity<Object> CredentialNotMatchedExceptionHandler(CredentialNotMatchedException ex,WebRequest wr){
        ErrorResponseModel erm=new ErrorResponseModel();
        erm.setErrorMessage(ex.getMessage());
        return new ResponseEntity<>(erm,HttpStatus.OK);
    }

}
