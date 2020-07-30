package com.globallogic.evaluation.userapi.converter;

import com.globallogic.evaluation.userapi.entity.UserEntity;
import com.globallogic.evaluation.userapi.helper.ConverterFile;
import com.globallogic.evaluation.userapi.model.UserRs;
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

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
class UserEntityToUserRsTest {

    @Value("classpath:objetos/userEntity.json")
    Resource userFile;

    @Autowired
    private ConversionService conversionService;

    @Test
    void convert() throws IOException {
        UserEntity userEntity = ConverterFile.resourceToObject(userFile, UserEntity.class);
        UserRs userRs = conversionService.convert(userEntity, UserRs.class);
        assertTrue(userRs.getToken().length()>0);
    }

}