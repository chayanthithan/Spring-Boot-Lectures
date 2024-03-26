package com.example.validationService.ExceptionHandler;


import com.example.validationService.model.ErrorResponse;
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
    @ExceptionHandler(UserNotFoundException.class)
    public final ResponseEntity<Object> handleUserNotFoundException(UserNotFoundException exception, WebRequest request){
        ErrorResponse errorResponse=new ErrorResponse();
        errorResponse.setMessage(exception.getMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);//404
    }
    @ExceptionHandler(NullPointerException.class)
    public final ResponseEntity<Object> handleNullPointerException(UserNotFoundException exception, WebRequest request){
        ErrorResponse errorResponse=new ErrorResponse();
        errorResponse.setMessage(exception.getMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);//500
    }

    @ExceptionHandler(CredentialNotFound.class)
    public final ResponseEntity<Object> handleCredentialNotFound(CredentialNotFound exception, WebRequest request){
        ErrorResponse errorResponse=new ErrorResponse();
        errorResponse.setMessage(exception.getMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);//400
    }
}
