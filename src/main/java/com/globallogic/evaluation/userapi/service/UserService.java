package com.globallogic.evaluation.userapi.service;

import com.globallogic.evaluation.userapi.dao.UserDAO;
import com.globallogic.evaluation.userapi.entity.UserEntity;
import com.globallogic.evaluation.userapi.model.UserInfo;
import com.globallogic.evaluation.userapi.model.UserRq;
import com.globallogic.evaluation.userapi.model.UserRs;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

import static com.globallogic.evaluation.userapi.util.StringConstants.EMAIL_EN_DB;


/**
 * Created by sati on 29-07-20.
 */

@Service
public class UserService {

    private static Logger logger  = LoggerFactory.getLogger(UserRq.class);

    @Autowired
    private UserDAO userDAO;

    @Autowired
    private ConversionService conversionService;

    @Transactional
    public UserRs create(UserRq user){
        logger.debug("Guardando usuario, UserRq {}", user.toString());
        user.validateEmail();
        user.validatePassword();
        this.validateUserInDB(user);
        UserEntity userEntity = conversionService.convert(user, UserEntity.class);
        logger.debug("Guardando usuario, userEntity {}", userEntity.toString());
        UserEntity userSave = userDAO.save(userEntity);
        UserRs userResponse = conversionService.convert(userSave,UserRs.class);
        logger.debug("Guardando usuario, userResponse {}", userResponse.toString());
        return userResponse;
    }

    public List<UserInfo> getList() {
        List<UserEntity> listEntity = userDAO.findAll();
        logger.debug("Obteniendo lista de usuario, listEntity {}", listEntity.toString());
        List<UserInfo> listUserInfo = listEntity.stream().map(userEntity ->
                conversionService.convert(userEntity, UserInfo.class)).collect(Collectors.toList());
        logger.debug("Obteniendo lista de usuario, listUserInfo {}", listUserInfo.toString());
        return listUserInfo;
    }

    private void validateUserInDB(UserRq user) {
        UserEntity userByEmail = userDAO.findByEmail(user.getEmail());
        if(userByEmail != null){
            throw new IllegalArgumentException(EMAIL_EN_DB);
        }
        logger.debug("Email no esta registrado ");
    }


}
