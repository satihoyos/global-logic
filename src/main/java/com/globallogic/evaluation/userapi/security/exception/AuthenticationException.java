package com.globallogic.evaluation.userapi.security.exception;

/**
 * Created by sati on 30-07-20.
 */
public class AuthenticationException extends RuntimeException {
    public AuthenticationException(String message, Throwable cause) {
        super(message, cause);
    }
}
