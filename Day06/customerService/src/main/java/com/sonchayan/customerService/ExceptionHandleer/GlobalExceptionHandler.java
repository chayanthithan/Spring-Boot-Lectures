package com.sonchayan.customerService.ExceptionHandleer;

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
    //user not found exception
    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<Object> handleUserNotFoundException(UserNotFoundException ex, WebRequest webRequest){
        return new ResponseEntity<>(ex, HttpStatus.OK);
    }
    //null pointer Exception
    @ExceptionHandler(NullPointerException.class)
    public ResponseEntity<Object> handleNullPointerException(NullPointerException exception,WebRequest webRequest){
        return new ResponseEntity<>(exception,HttpStatus.NOT_FOUND);
    }
    //credential exception
    @ExceptionHandler(CredentialException.class)
    public ResponseEntity<Object> handleCredentialException(CredentialException exception,WebRequest webRequest){
        return new ResponseEntity<>(exception,HttpStatus.BAD_REQUEST);
    }
}
