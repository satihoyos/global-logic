package com.globallogic.evaluation.userapi.helper;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.io.IOUtils;
import org.springframework.core.io.Resource;

import java.io.IOException;

/**
 * Created by sati on 30-07-20.
 */
public class ConverterFile {

    public static <T> T resourceToObject(Resource rs, Class<T> clazz) throws IOException {
        String structure = new String(IOUtils.toByteArray(rs.getInputStream()));
        return convert(structure,clazz);
    }

    public static <T> T convert(String json, Class<T> clazz) throws JsonProcessingException {
        return new ObjectMapper().readValue(json, clazz);
    }
}


