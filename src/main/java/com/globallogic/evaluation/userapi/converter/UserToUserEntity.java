package com.globallogic.evaluation.userapi.converter;

import com.globallogic.evaluation.userapi.annotation.TypeConverter;
import com.globallogic.evaluation.userapi.entity.PhoneEntity;
import com.globallogic.evaluation.userapi.entity.UserEntity;
import com.globallogic.evaluation.userapi.model.UserRq;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by sati on 29-07-20.
 */
@TypeConverter
public class UserToUserEntity implements Converter<UserRq, UserEntity>{

    private static Logger logger  = LoggerFactory.getLogger(UserToUserEntity.class);

    @Autowired
    private ConversionService conversionService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Nullable
    @Override
    public UserEntity convert(UserRq user) {
        logger.debug("Mapeando User To UserEntity");
        Date toDay = new Date();
        UserEntity entity = new UserEntity();
        entity.setName(user.getName());
        entity.setEmail(user.getEmail());
        entity.setEnabled(true);
        entity.setPassword(passwordEncoder.encode(user.getPassword()));
        entity.setCreate(toDay);
        entity.setModified(toDay);
        entity.setLastLogin(toDay);
        List<PhoneEntity> phones = user.getPhones().stream()
                        .map(phone -> conversionService.convert(phone, PhoneEntity.class)).collect(Collectors.toList());
        entity.setPhones(phones);
        return entity;
    }
}
