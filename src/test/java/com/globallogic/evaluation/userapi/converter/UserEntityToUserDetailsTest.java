package com.globallogic.evaluation.userapi.converter;

import com.globallogic.evaluation.userapi.entity.PhoneEntity;
import com.globallogic.evaluation.userapi.entity.UserEntity;
import com.globallogic.evaluation.userapi.helper.ConverterFile;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.io.Resource;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by sati on 30-07-20.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
class UserEntityToUserDetailsTest {

    @Value("classpath:objetos/userEntity.json")
    Resource userFile;

    @Autowired
    private ConversionService conversionService;

    @Test
    void convert() throws IOException {
        UserEntity userEntity = ConverterFile.resourceToObject(userFile, UserEntity.class);
        UserDetails userDetails = conversionService.convert(userEntity, UserDetails.class);
        assertEquals(userDetails.getPassword(),userEntity.getPassword());
        assertEquals(userDetails.getUsername(),userEntity.getEmail());
        assertTrue(userDetails.getAuthorities().size()==0);
    }

}