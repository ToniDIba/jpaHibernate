package com.example.jpaHibernate.config.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

public class UnprocesableException {

    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)

    public class UnProcesableException extends RuntimeException {

        public UnProcesableException(String message) {
            super(message);
        }

    }
}
