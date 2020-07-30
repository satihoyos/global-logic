package com.globallogic.evaluation.userapi.model;

import java.util.List;

/**
 * Created by sati on 30-07-20.
 */
public class UserInfo extends UserCommonData {
    private String username;
    private List<Phone>phones;

    public List<Phone> getPhones() {
        return phones;
    }

    public void setPhones(List<Phone> phones) {
        this.phones = phones;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return "UserInfo{" +
                "username='" + username + '\'' +
                ", phones=" + phones +
                "} " + super.toString();
    }
}
