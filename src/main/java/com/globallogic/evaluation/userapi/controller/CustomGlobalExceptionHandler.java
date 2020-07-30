package com.globallogic.evaluation.userapi.controller;

import com.globallogic.evaluation.userapi.model.ErrorRs;
import com.globallogic.evaluation.userapi.security.exception.AuthenticationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * Created by sati on 29-07-20.
 */
@ControllerAdvice
public class CustomGlobalExceptionHandler {

    private static Logger logger  = LoggerFactory.getLogger(CustomGlobalExceptionHandler.class);

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorRs>manageEmailException(IllegalArgumentException ex){
        logger.error("Error en datos de entrada. ", ex);
        ErrorRs errorRs = new ErrorRs(ex.getMessage());
        return new ResponseEntity<>(errorRs, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(AuthenticationException.class)
    public ResponseEntity<ErrorRs>manageEmailException(AuthenticationException ex){
        logger.error("Error en datos de authenticacion. ", ex);
        ErrorRs errorRs = new ErrorRs(ex.getMessage());
        return new ResponseEntity<>(errorRs, HttpStatus.BAD_REQUEST);
    }
}
