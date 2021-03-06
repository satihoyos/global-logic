package com.globallogic.evaluation.userapi.converter;

import com.globallogic.evaluation.userapi.entity.PhoneEntity;
import com.globallogic.evaluation.userapi.helper.ConverterFile;
import com.globallogic.evaluation.userapi.model.Phone;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.io.Resource;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by sati on 30-07-20.
 */
@SpringBootTest
class PhoneEntityToPhoneTest {

    @Value("classpath:objetos/phoneEntity.json")
    Resource phoneFile;

    @Autowired
    private ConversionService conversionService;

    @Test
    void convert() throws IOException {
        PhoneEntity phoneEntity = ConverterFile.resourceToObject(phoneFile, PhoneEntity.class);
        Phone phone = conversionService.convert(phoneEntity, Phone.class);
        assertEquals(phone.getNumber(),phoneEntity.getNumber());
        assertEquals(phone.getContryCode(),phoneEntity.getContryCode());
        assertEquals(phone.getCityCode(),phoneEntity.getCityCode());
    }
}