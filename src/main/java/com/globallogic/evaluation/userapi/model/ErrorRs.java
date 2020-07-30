package com.globallogic.evaluation.userapi.model;

/**
 * Created by sati on 29-07-20.
 */
public class ErrorRs {

    private String message;

    public ErrorRs(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    @Override
    public String toString() {
        return "ErrorRs{" +
                "message='" + message + '\'' +
                '}';
    }
}
