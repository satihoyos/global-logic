package com.globallogic.evaluation.userapi.converter;

import com.globallogic.evaluation.userapi.annotation.TypeConverter;
import com.globallogic.evaluation.userapi.entity.UserEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;

/**
 * Created by sati on 30-07-20.
 */
@TypeConverter
public class UserEntityToUserDetails implements Converter<UserEntity,UserDetails>
{

    private static Logger logger  = LoggerFactory.getLogger(UserEntityToUserDetails.class);

    @Nullable
    @Override
    public UserDetails convert(UserEntity userEntity) {
        logger.debug("Mapeando UserEntity To UserDetails");
        return new User(userEntity.getEmail(), userEntity.getPassword(),
                userEntity.getEnabled(),
                true,true,true, new ArrayList<>());
    }
}
