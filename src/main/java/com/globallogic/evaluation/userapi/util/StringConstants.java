package com.globallogic.evaluation.userapi.util;

/**
 * Created by sati on 30-07-20.
 */
public class StringConstants {

    private StringConstants() {
    }

    public static final String EMAIL_EN_DB = "El e-mail ya está registrado.";
    public static final String EMAIL_BAD_PATTERN = "El formato del e-mail no es valido";
    public static final String EMAIL_NULL = "No se ha enviado e-mail del usuario";
    public static final String PASSWORD_NULL = "No se ha enviado password";
    public static final String PASSWORD_REGEX = "^(?=.*\\d{2,})(?=.*[A-Z]{1})(?=.*[a-z]).{4,10}$";
    public static final String EMAIL_REGEX = "^[_a-z0-9-]+(\\.[_a-z0-9-]+)*@" +
            "[a-z0-9-]+(\\.[a-z0-9-]+)*(\\.[a-z]{2,4})$";
    public static final String PASSWORD_BAD_PATTERN = "La Password debe contener: dos numéros seguidos, " +
            "una mayúscula, letras minúsculas ";
}
