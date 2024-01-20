package com.stallion.serviceterminus.utils;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;
import java.util.Map;

public class StallionResponseHandler {
    public static ResponseEntity<Object> responseBuilder(String message, HttpStatus http, Object responseObject){
           Map<String, Object> response = new HashMap<>();
           response.put("message", message);
           response.put("httpStatus", http);
           response.put("data", responseObject);
           return new ResponseEntity<>(response,http);
    }
}
