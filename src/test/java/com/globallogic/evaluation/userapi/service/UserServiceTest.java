package com.globallogic.evaluation.userapi.service;

import com.globallogic.evaluation.userapi.dao.UserDAO;
import com.globallogic.evaluation.userapi.entity.PhoneEntity;
import com.globallogic.evaluation.userapi.entity.UserEntity;
import com.globallogic.evaluation.userapi.helper.ConverterFile;
import com.globallogic.evaluation.userapi.model.UserInfo;
import com.globallogic.evaluation.userapi.model.UserRq;
import com.globallogic.evaluation.userapi.model.UserRs;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.io.Resource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by sati on 30-07-20.
 */
@SpringBootTest
class UserServiceTest {

    @MockBean
    private UserDAO userDAO;

    @Autowired
    private UserService userService;

    @Value("classpath:objetos/userEntity.json")
    Resource userFile;

    @Value("classpath:objetos/userRq.json")
    Resource userRqFile;


    @Test
    void createSucces() throws IOException {
        UserEntity userEntity = ConverterFile.resourceToObject(userFile, UserEntity.class);
        UserRq userRq = ConverterFile.resourceToObject(userRqFile, UserRq.class);
        Mockito.doReturn(null).when(userDAO).findByEmail(Mockito.eq(userRq.getEmail()));
        Mockito.doReturn(userEntity).when(userDAO).save(Mockito.any(UserEntity.class));

        UserRs userRs = userService.create(userRq);
        Mockito.verify(userDAO).findByEmail(Mockito.eq(userRq.getEmail()));
        Mockito.verify(userDAO).save(Mockito.any(UserEntity.class));
        assertTrue(userRs.getToken().length()>0);
    }

    @Test
    void createBadFormatEmail()throws IOException {
        UserRq userRq = new UserRq();
        userRq.setEmail("prueba@prb.cl1");
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            userService.create(userRq);
        });
    }

    @Test
    void createBadFormatPassword()throws IOException {
        UserRq userRq = new UserRq();
        userRq.setEmail("prueba@prb.cl");
        userRq.setPassword("hola12");
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            userService.create(userRq);
        });
    }

    @Test
    void createEmailInDB()throws IOException {
        UserEntity userEntity = ConverterFile.resourceToObject(userFile, UserEntity.class);
        UserRq userRq = ConverterFile.resourceToObject(userRqFile, UserRq.class);
        Mockito.doReturn(userEntity).when(userDAO).findByEmail(Mockito.eq(userRq.getEmail()));

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            userService.create(userRq);
        });
    }

    @Test
    void getList() throws IOException {
        UserEntity userEntity = ConverterFile.resourceToObject(userFile, UserEntity.class);
        List<UserEntity>lista = new ArrayList<>();
        lista.add(userEntity);
        Mockito.doReturn(lista).when(userDAO).findAll();

        List<UserInfo> userInfoList= userService.getList();
        UserInfo userInfo1 = userInfoList.get(0);

        Mockito.verify(userDAO).findAll();
        assertEquals(userInfo1.getModified(), userInfo1.getModified());
        assertEquals(userInfo1.getLastLogin(), userInfo1.getLastLogin());
        assertEquals(userInfo1.getCreated(), userInfo1.getCreated());
        assertEquals(userInfo1.getUsername(), userInfo1.getUsername());
        assertEquals(userInfo1.getId(), userInfo1.getId());
        assertEquals(userInfo1.getPhones().size(), userInfo1.getPhones().size());
    }

}