package com.stallion.serviceterminus.error;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class ApplicationExceptionHandler {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Object> handleInvalidArguments(MethodArgumentNotValidException exception){
        Map<String, String> error = new HashMap<>();
        exception.getBindingResult().getFieldErrors().forEach(fieldError -> {
            error.put(fieldError.getField(), fieldError.getDefaultMessage());
        });
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST) ;
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(TerminusGenericException.class)
    public ResponseEntity<Object> handleInvalidArguments(TerminusGenericException exception){
        Map<String, Object> error = new HashMap<>();
        error.put("message", exception.getMessage());
        error.put("throwable", exception.getCause());
        error.put("httpStatus", HttpStatus.INTERNAL_SERVER_ERROR);
//        GenericException genericException = new GenericException(
//                exception.getMessage(),
//                exception.getCause(),
//                HttpStatus.NOT_FOUND
//        );
        return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR) ;
    }

}
