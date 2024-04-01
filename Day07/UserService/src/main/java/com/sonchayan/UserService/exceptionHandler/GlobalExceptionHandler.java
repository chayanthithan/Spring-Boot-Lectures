package com.sonchayan.UserService.exceptionHandler;

import com.sonchayan.UserService.model.ErrorResponseModel;
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
    @ExceptionHandler(CredentialNotMatchedException.class)
    public ResponseEntity<Object> userNotFoundHandler(CredentialNotMatchedException ex, WebRequest webRequest){
        ErrorResponseModel erm=new ErrorResponseModel();
        erm.setErrorMessage(ex.getMessage());
        return new ResponseEntity<>(erm, HttpStatus.NOT_ACCEPTABLE);
    }
    @ExceptionHandler(NullPointerException.class)
    public ResponseEntity<Object> userNotFoundHandler(NullPointerException ex, WebRequest webRequest){
        ErrorResponseModel erm=new ErrorResponseModel();
        erm.setErrorMessage(ex.getMessage());
        return new ResponseEntity<>(erm, HttpStatus.NO_CONTENT);
    }
    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<Object> userNotFoundHandler(UserNotFoundException ex, WebRequest webRequest){
        ErrorResponseModel erm=new ErrorResponseModel();
        erm.setErrorMessage(ex.getMessage());
        return new ResponseEntity<>(erm, HttpStatus.NOT_FOUND);
    }
}
