package com.globallogic.evaluation.userapi.converter;

import com.globallogic.evaluation.userapi.entity.UserEntity;
import com.globallogic.evaluation.userapi.helper.ConverterFile;
import com.globallogic.evaluation.userapi.model.UserRq;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.io.Resource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by sati on 30-07-20.
 */
@SpringBootTest
class UserToUserEntityTest {

    @Value("classpath:objetos/userRq.json")
    Resource userFile;

    @Autowired
    private ConversionService conversionService;


    @Test
    void convert() throws IOException {
        UserRq userRq = ConverterFile.resourceToObject(userFile, UserRq.class);
        UserEntity userEntity = conversionService.convert(userRq, UserEntity.class);
        assertEquals(userEntity.getEmail(), userRq.getEmail());
        assertEquals(userEntity.getName(), userRq.getName());
        assertTrue(userEntity.getPhones().size()>0);
        assertTrue(userEntity.getPassword().length()>0);
        assertTrue(userEntity.getCreate().toString().length()>0);
        assertTrue(userEntity.getModified().toString().length()>0);
        assertTrue(userEntity.getLastLogin().toString().length()>0);
    }

}