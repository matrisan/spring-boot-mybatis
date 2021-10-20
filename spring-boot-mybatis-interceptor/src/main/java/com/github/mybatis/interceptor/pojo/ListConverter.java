package com.github.mybatis.interceptor.pojo;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.apache.commons.lang3.StringUtils;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.Collections;
import java.util.List;

/**
 * create in 2021/2/24 4:57 下午
 *
 * @author shishaodong
 * @version 0.0.1
 */
@Converter(autoApply = true)
@RequiredArgsConstructor
public class ListConverter implements AttributeConverter<List<BookValue>, String> {

    private final ObjectMapper objectMapper;

    private static final TypeReference<List<BookValue>> type = new TypeReference<>() {
    };

    @SneakyThrows(JsonProcessingException.class)
    @Override
    public String convertToDatabaseColumn(List<BookValue> attribute) {
        return objectMapper.writeValueAsString(attribute);
    }

    @Override
    @SneakyThrows(JsonProcessingException.class)
    public List<BookValue> convertToEntityAttribute(String dbData) {
        if (StringUtils.isBlank(dbData)) {
            return Collections.emptyList();
        }
        return objectMapper.readValue(dbData, type);
    }
}
