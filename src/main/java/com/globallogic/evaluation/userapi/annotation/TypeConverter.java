package com.globallogic.evaluation.userapi.annotation;

import org.springframework.stereotype.Component;

import java.lang.annotation.*;

/**
 * Created by sati on 29-07-20.
 */
@Target({ElementType.TYPE, ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Component
public @interface TypeConverter {
}
