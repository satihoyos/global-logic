package com.globallogic.evaluation.userapi.converter;

import com.globallogic.evaluation.userapi.annotation.TypeConverter;
import com.globallogic.evaluation.userapi.entity.PhoneEntity;
import com.globallogic.evaluation.userapi.model.Phone;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;

import java.util.Date;

/**
 * Created by sati on 29-07-20.
 */
@TypeConverter
public class PhoneToPhoneEntity implements Converter<Phone,PhoneEntity> {

    private static Logger logger  = LoggerFactory.getLogger(PhoneEntityToPhone.class);

    @Nullable
    @Override
    public PhoneEntity convert(Phone phone) {
        logger.debug("Mapeando Phone To PhoneEntity");
        Date toDay = new Date();
        PhoneEntity phoneEntity = new PhoneEntity();
        phoneEntity.setCityCode(phone.getCityCode());
        phoneEntity.setNumber(phone.getNumber());
        phoneEntity.setContryCode(phone.getContryCode());
        phoneEntity.setCreate(toDay);
        phoneEntity.setModified(toDay);
        return phoneEntity;
    }
}
