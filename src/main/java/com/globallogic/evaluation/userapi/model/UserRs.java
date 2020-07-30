package com.globallogic.evaluation.userapi.model;

import java.util.Date;

/**
 * Created by sati on 30-07-20.
 */
public class UserRs extends UserCommonData{

    private String token;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @Override
    public String toString() {
        return "UserRs{" +
                "token='" + token + '\'' +
                "} " + super.toString();
    }
}
