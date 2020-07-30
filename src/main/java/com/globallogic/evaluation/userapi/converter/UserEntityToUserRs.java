package com.globallogic.evaluation.userapi.converter;

import com.globallogic.evaluation.userapi.annotation.TypeConverter;
import com.globallogic.evaluation.userapi.entity.UserEntity;
import com.globallogic.evaluation.userapi.model.UserRs;
import com.globallogic.evaluation.userapi.security.service.JwtTokenUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * Created by sati on 30-07-20.
 */
@TypeConverter
public class UserEntityToUserRs implements Converter<UserEntity,UserRs> {

    private static Logger logger  = LoggerFactory.getLogger(UserEntityToUserInfo.class);

    @Autowired
    private ConversionService conversionService;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Nullable
    @Override
    public UserRs convert(UserEntity userEntity) {
        logger.debug("Mapeando UserEntity To UserRs");
        UserRs userRs = new UserRs();
        userRs.setId(userEntity.getId());
        userRs.setActive(userEntity.getEnabled());
        userRs.setCreated(userEntity.getCreate());
        userRs.setLastLogin(userEntity.getLastLogin());
        userRs.setModified(userEntity.getModified());
        userRs.setToken(jwtTokenUtil.generateToken(conversionService.convert(userEntity, UserDetails.class)));
        return userRs;
    }

}
