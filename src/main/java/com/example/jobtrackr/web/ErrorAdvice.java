package com.example.jobtrackr.web;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import java.util.*;

@RestControllerAdvice
public class ErrorAdvice {
  @ExceptionHandler(MethodArgumentNotValidException.class)
  @ResponseStatus(HttpStatus.BAD_REQUEST)
  Map<String, Object> handleValidation(MethodArgumentNotValidException ex){
    Map<String, Object> body = new LinkedHashMap<>();
    body.put("error", "validation");
    body.put("details", ex.getBindingResult().getFieldErrors().stream()
      .map(e -> Map.of("field", e.getField(), "message", e.getDefaultMessage()))
      .toList());
    return body;
  }

  @ExceptionHandler(NoSuchElementException.class)
  @ResponseStatus(HttpStatus.NOT_FOUND)
  Map<String, Object> notFound(){ return Map.of("error","not_found"); }

  @ExceptionHandler(MethodArgumentTypeMismatchException.class)
  @ResponseStatus(HttpStatus.BAD_REQUEST)
  Map<String, Object> badPath(){ return Map.of("error","bad_request"); }
}
