package com.sonchayan.EmployeeService.exceptionHaandler;

import com.sonchayan.EmployeeService.model.ErrorResponseModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestController
@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(NullPointerException.class)
    public ResponseEntity<Object> handleNullPinterException(NullPointerException exception, WebRequest webRequest){
        ErrorResponseModel errorResponseModel=new ErrorResponseModel();
        errorResponseModel.setErrorMessage("nullpointer exception");
        return new ResponseEntity<>(errorResponseModel, HttpStatus.OK);
    }
    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<Object> handleUserNotFoundException(UserNotFoundException exception, WebRequest webRequest){
        ErrorResponseModel errorResponseModel=new ErrorResponseModel();
        errorResponseModel.setErrorMessage("User Not found Exception");
        return new ResponseEntity<>(errorResponseModel, HttpStatus.OK);
    }
    @ExceptionHandler(CredentialNotFoundException.class)
    public ResponseEntity<Object> handleCredentialException(CredentialNotFoundException exception,WebRequest webRequest){
        ErrorResponseModel errorResponseModel=new ErrorResponseModel();
        errorResponseModel.setErrorMessage("credential not matched");
        return new ResponseEntity<>(errorResponseModel,HttpStatus.BAD_REQUEST);
    }
}
