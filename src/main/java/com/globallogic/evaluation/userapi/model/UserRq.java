package com.globallogic.evaluation.userapi.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.globallogic.evaluation.userapi.util.StringConstants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.regex.Pattern;

import static com.globallogic.evaluation.userapi.util.StringConstants.*;

/**
 * Created by sati on 29-07-20.
 */
public class UserRq {

    private static Logger logger  = LoggerFactory.getLogger(UserRq.class);

    private String name;
    private String email;
    private String password;
    private List<Phone> phones;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Phone> getPhones() {
        return phones;
    }

    public void setPhones(List<Phone> phones) {
        this.phones = phones;
    }

    @JsonIgnore
    public void validatePassword(){
        this.validStringNull(this.password,PASSWORD_NULL);
        this.validPattern(Pattern.compile(PASSWORD_REGEX),this.password,PASSWORD_BAD_PATTERN);
        logger.debug("password valido");
    }

    @JsonIgnore
    public void validateEmail(){
        this.validStringNull(this.email,EMAIL_NULL);
        this.validPattern(Pattern.compile(EMAIL_REGEX), this.email,EMAIL_BAD_PATTERN);
        logger.debug("Email valido");
    }

    private void validStringNull(String value, String errorMessage){
        if(value == null || value.isEmpty()){
            logger.error("Error al validar campo, es nulo o empty {}", errorMessage);
            throw new IllegalArgumentException(errorMessage);
        }
    }

    private void validPattern(Pattern pattern, String value, String errorMsg){
        if(!pattern.matcher(value).matches()){
            logger.error("Error al validar campo: {}, no cumple pattern", value, errorMsg);
            throw new IllegalArgumentException(errorMsg);
        }
    }

    @Override
    public String toString() {
        return "UserRq{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", phones=" + phones +
                '}';
    }
}
