package com.example.jpaHibernate.config.exception;



import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;




import java.util.Date;

@RestControllerAdvice
public class MiResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(NotFoundExceptionToni.class)
    public final ResponseEntity<CustomError> handleNotFoundException(NotFoundExceptionToni ex) {

        CustomError exceptionResponse = new CustomError(new Date(), ex.getMessage(), 404);
        return new ResponseEntity<CustomError>(exceptionResponse, HttpStatus.NOT_ACCEPTABLE);

    }

    @ExceptionHandler(HttpClientErrorException.UnprocessableEntity.class)
    public final ResponseEntity<CustomError> handleNotFoundException(HttpClientErrorException.UnprocessableEntity un) {

        CustomError exceptionResponse = new CustomError(new Date(), un.getMessage(), 422);
        return new ResponseEntity<CustomError>(exceptionResponse, HttpStatus.UNPROCESSABLE_ENTITY);

    }

}
