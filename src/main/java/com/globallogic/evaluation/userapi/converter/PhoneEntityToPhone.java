package com.globallogic.evaluation.userapi.converter;

import com.globallogic.evaluation.userapi.annotation.TypeConverter;
import com.globallogic.evaluation.userapi.entity.PhoneEntity;
import com.globallogic.evaluation.userapi.model.Phone;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;

/**
 * Created by sati on 30-07-20.
 */
@TypeConverter
public class PhoneEntityToPhone implements Converter<PhoneEntity,Phone> {

    private static Logger logger  = LoggerFactory.getLogger(PhoneEntityToPhone.class);

    @Nullable
    @Override
    public Phone convert(PhoneEntity phoneEntity) {
        logger.debug("Mapeando PhoneEntity To Phone");
        Phone phone = new Phone();
        phone.setCityCode(phoneEntity.getCityCode());
        phone.setContryCode(phoneEntity.getContryCode());
        phone.setNumber(phoneEntity.getNumber());
        return phone;
    }
}
