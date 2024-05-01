package com.sonchayan.playerservice.errorHandler;

import com.sonchayan.playerservice.model.ErrorMessageModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@RestController
public class GlobalHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<Object> UserNotFoundExceptionHandler(UserNotFoundException ex, WebRequest web){
        ErrorMessageModel em=new ErrorMessageModel();
        em.setErrorMessage(ex.getMessage());
        return  new ResponseEntity<>(em, HttpStatus.OK);
    }

    @ExceptionHandler(WrongCredentialException.class)
    public ResponseEntity<Object> WrongCredentialExceptionHandler(WrongCredentialException ex, WebRequest web){
        ErrorMessageModel em=new ErrorMessageModel();
        em.setErrorMessage(ex.getMessage());
        return  new ResponseEntity<>(em, HttpStatus.OK);
    }
    @ExceptionHandler(NullPointerException.class)
    public ResponseEntity<Object> NullPointerExceptionHandler(NullPointerException ex, WebRequest web){
        ErrorMessageModel em=new ErrorMessageModel();
        em.setErrorMessage(ex.getMessage());
        return  new ResponseEntity<>(em, HttpStatus.OK);
    }

}
