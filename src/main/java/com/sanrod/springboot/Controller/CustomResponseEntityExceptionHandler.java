package com.sanrod.springboot.Controller;

import com.sanrod.springboot.Exceptions.HeroNotFoundException;
import com.sanrod.springboot.Model.CustomExceptionResponse;
import org.jspecify.annotations.Nullable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

@ControllerAdvice //con esta anotación todos los métodos de esta clase se aplicará a todos los controladores de nuesta aplicación
@Controller
public class CustomResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handleCustomException(Exception ex, WebRequest request) {
        CustomExceptionResponse customExceptionResponse = new CustomExceptionResponse(new Date(), ex.getMessage(), request.getDescription(false));

        return new ResponseEntity<>(customExceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(HeroNotFoundException.class)
    public ResponseEntity<Object> handleHeroNotFoundException(Exception ex, WebRequest request) {
        CustomExceptionResponse customExceptionResponse = new CustomExceptionResponse(new Date(), ex.getMessage(), request.getDescription(false));

        return new ResponseEntity<>(customExceptionResponse, HttpStatus.NOT_FOUND);
    }
    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        CustomExceptionResponse customExceptionResponse = new CustomExceptionResponse(new Date(), "Error de validacion", ex.getBindingResult().toString());

        return new ResponseEntity<>(customExceptionResponse, HttpStatus.BAD_REQUEST);
    }


}
