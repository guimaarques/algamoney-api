package com.algaworks.algamoney.api.exceptions;

import com.algaworks.algamoney.api.errors.ResponseError;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice //observe the application
public class AlgaMoneyExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ResourceNotFound.class)
    public ResponseEntity<ResponseError> error(){
        ResponseError error = new ResponseError(HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase());
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

    public AlgaMoneyExceptionHandler() {
    }
}
