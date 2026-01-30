package com.ecommerce.auth_service.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<Map<String, Object>> handleIllegalArgument(IllegalArgumentException ex) {
        Map<String, Object> body = new HashMap<>();
        body.put("timestamp", LocalDateTime.now());
        body.put("message", ex.getMessage());
        body.put("status", HttpStatus.BAD_REQUEST.value());
        return new ResponseEntity<>(body, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Map<String, Object>> handleGeneralException(Exception ex) {
        Map<String, Object> body = new HashMap<>();
        body.put("timestamp", LocalDateTime.now());
        body.put("message", "Internal server error");
        body.put("details", ex.getMessage());
        body.put("status", HttpStatus.INTERNAL_SERVER_ERROR.value());
        return new ResponseEntity<>(body, HttpStatus.INTERNAL_SERVER_ERROR);
    }

}

//
//package com.ecommerce.auth_service.exception;
//
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.security.access.AccessDeniedException;
//import org.springframework.security.authentication.BadCredentialsException;
//import org.springframework.web.bind.annotation.ExceptionHandler;
//import org.springframework.web.bind.annotation.RestControllerAdvice;
//
//import java.time.LocalDateTime;
//import java.util.HashMap;
//import java.util.Map;
//
//@RestControllerAdvice
//public class GlobalExceptionHandler {
//
//    // Handle Illegal arguments
//    @ExceptionHandler(IllegalArgumentException.class)
//    public ResponseEntity<Map<String, Object>> handleIllegalArgument(IllegalArgumentException ex) {
//        return buildResponse(ex.getMessage(), HttpStatus.BAD_REQUEST, ex.getMessage());
//    }
//
//    // Handle duplicate username/email or other custom RuntimeExceptions
//    @ExceptionHandler(RuntimeException.class)
//    public ResponseEntity<Map<String, Object>> handleRuntime(RuntimeException ex) {
//        HttpStatus status;
//
//        String msg = ex.getMessage();
//        if (msg.contains("exists")) {
//            status = HttpStatus.CONFLICT; // 409 for duplicates
//        } else if (msg.contains("not found") || msg.contains("Invalid password")) {
//            status = HttpStatus.UNAUTHORIZED; // 401 for auth failures
//        } else {
//            status = HttpStatus.BAD_REQUEST;
//        }
//
//        return buildResponse(msg, status, msg);
//    }
//
//    // Handle security / access denied (403)
//    @ExceptionHandler(AccessDeniedException.class)
//    public ResponseEntity<Map<String, Object>> handleAccessDenied(AccessDeniedException ex) {
//        return buildResponse("Access denied", HttpStatus.FORBIDDEN, ex.getMessage());
//    }
//
//    // Handle authentication failures (bad credentials)
//    @ExceptionHandler(BadCredentialsException.class)
//    public ResponseEntity<Map<String, Object>> handleBadCredentials(BadCredentialsException ex) {
//        return buildResponse("Invalid username or password", HttpStatus.UNAUTHORIZED, ex.getMessage());
//    }
//
//    // Catch-all for unexpected errors
//    @ExceptionHandler(Exception.class)
//    public ResponseEntity<Map<String, Object>> handleGeneral(Exception ex) {
//        return buildResponse("Internal server error", HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage());
//    }
//
//    // Helper method to build response
//    private ResponseEntity<Map<String, Object>> buildResponse(String message, HttpStatus status, String details) {
//        Map<String, Object> body = new HashMap<>();
//        body.put("timestamp", LocalDateTime.now());
//        body.put("status", status.value());
//        body.put("error", status.getReasonPhrase());
//        body.put("message", message);
//        body.put("details", details);
//        return new ResponseEntity<>(body, status);
//    }
//}
