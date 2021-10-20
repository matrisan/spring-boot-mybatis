package com.github.mybatis.interceptor.config;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.mybatis.interceptor.pojo.BookValue;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * TODO
 * <p>
 * create in 2021/7/6 4:10 下午
 *
 * @author shishaodong
 * @version 0.0.1
 */

@Slf4j
@Component
@MappedJdbcTypes(JdbcType.VARCHAR)
public class BookValueTypeHandler extends BaseTypeHandler<List<BookValue>> {

    private static final TypeReference<List<BookValue>> TYPE_REFERENCE = new TypeReference<>() {
    };

    @Resource
    private ObjectMapper objectMapper;

    @Override
    @SneakyThrows({JsonProcessingException.class})
    public void setNonNullParameter(PreparedStatement ps, int i, List<BookValue> parameter, JdbcType jdbcType) throws SQLException {
        ps.setString(i, objectMapper.writeValueAsString(parameter));
    }

    @Override
    @SneakyThrows({JsonProcessingException.class})
    public List<BookValue> getNullableResult(ResultSet rs, String columnName) throws SQLException {
        return objectMapper.readValue(rs.getString(columnName), TYPE_REFERENCE);
    }

    @Override
    @SneakyThrows({JsonProcessingException.class})
    public List<BookValue> getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        return objectMapper.readValue(rs.getString(columnIndex), TYPE_REFERENCE);
    }

    @Override
    @SneakyThrows({JsonProcessingException.class})
    public List<BookValue> getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        return objectMapper.readValue(cs.getString(columnIndex), TYPE_REFERENCE);
    }
}
