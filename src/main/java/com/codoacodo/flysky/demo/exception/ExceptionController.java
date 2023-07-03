package com.codoacodo.flysky.demo.exception;

import com.codoacodo.flysky.demo.dto.response.ExceptionDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.NoSuchElementException;

@ControllerAdvice
public class ExceptionController {

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<?> notFound(NotFoundException e){
        ExceptionDto exceptionDto = new ExceptionDto(404, e.getMessage());
        return new ResponseEntity<>(exceptionDto, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(UnAuthorizedException.class)
    public ResponseEntity<?> unAuthorized(UnAuthorizedException e){
        ExceptionDto exceptionDto = new ExceptionDto(401, e.getMessage());
        return new ResponseEntity<>(exceptionDto, HttpStatus.UNAUTHORIZED);
    }

    @ExceptionHandler(.class)
    public ResponseEntity<?> NoSuchElemen(NoSuchElementException e){
        ExceptionDto exceptionDto = new ExceptionDto(500, e.getMessage()
                .replace("No value present", "Usuario no registrado."));
        return new ResponseEntity<>(exceptionDto, HttpStatus.INTERNAL_SERVER_ERROR);
    }



}
