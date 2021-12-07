package com.example.jpaHibernate.config.exception;



import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


import javax.persistence.NoResultException;
import java.util.Date;

@RestControllerAdvice
public class MiResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {


    @ExceptionHandler(NotFoundExceptionToni.class)
    public final ResponseEntity<CustomError> handleNotFoundException(NotFoundExceptionToni ex) {

        CustomError exceptionResponse = new CustomError(new Date(), ex.getMessage(), 404);
        return new ResponseEntity<CustomError>(exceptionResponse, HttpStatus.NOT_ACCEPTABLE);

    }



    @ExceptionHandler(UnprocesableExceptionToni.class)
    public final ResponseEntity<CustomError> handleNotFoundException(UnprocesableExceptionToni ex) {

        CustomError exceptionResponse = new CustomError(new Date(), ex.getMessage(), 422);
        return new ResponseEntity<CustomError>(exceptionResponse, HttpStatus.UNPROCESSABLE_ENTITY);

    }

/* sergi
    @ExceptionHandler(NoResultException.class)
    public final ResponseEntity<CustomError> handleNotFoundException(NoResultException ex) {

        CustomError exceptionResponse = new CustomError(new Date(), ex.getMessage(), 422);
        return new ResponseEntity<CustomError>(exceptionResponse, HttpStatus.UNPROCESSABLE_ENTITY);

    } */




}
