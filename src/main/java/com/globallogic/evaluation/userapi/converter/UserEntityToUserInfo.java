package com.globallogic.evaluation.userapi.converter;

import com.globallogic.evaluation.userapi.annotation.TypeConverter;
import com.globallogic.evaluation.userapi.entity.UserEntity;
import com.globallogic.evaluation.userapi.model.Phone;
import com.globallogic.evaluation.userapi.model.UserInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by sati on 30-07-20.
 */
@TypeConverter
public class UserEntityToUserInfo implements Converter<UserEntity,UserInfo>{
    private static Logger logger  = LoggerFactory.getLogger(UserEntityToUserInfo.class);

    @Autowired
    private ConversionService conversionService;

    @Nullable
    @Override
    public UserInfo convert(UserEntity userEntity) {
        logger.debug("Mapeando UserEntity To UserInfo");
        UserInfo userInfo = new UserInfo();
        userInfo.setId(userEntity.getId());
        userInfo.setUsername(userEntity.getEmail());
        userInfo.setActive(userEntity.getEnabled());
        userInfo.setCreated(userEntity.getCreate());
        userInfo.setLastLogin(userEntity.getLastLogin());
        userInfo.setModified(userEntity.getModified());
        List<Phone> phones = userEntity.getPhones().stream()
                .map((phoneEntity) -> conversionService.convert(phoneEntity, Phone.class))
                .collect(Collectors.toList());
        userInfo.setPhones(phones);
        return userInfo;
    }
}
