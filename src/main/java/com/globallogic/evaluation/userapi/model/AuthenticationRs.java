package com.globallogic.evaluation.userapi.model;

/**
 * Created by sati on 30-07-20.
 */
public class AuthenticationRs {

    private String token;

    public AuthenticationRs(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }

    @Override
    public String toString() {
        return "AuthenticationRs{" +
                "token='" + token + '\'' +
                '}';
    }
}
