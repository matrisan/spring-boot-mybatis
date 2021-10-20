package com.github.mybatis.common.config;

import com.github.mybatis.common.pojo.value.SexEnum;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * TODO
 * <p>
 * create in 2021/7/14 9:45 上午
 *
 * @author shishaodong
 * @version 0.0.1
 */

@Slf4j
public class SexTypeHandler extends BaseTypeHandler<SexEnum> {


    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, SexEnum parameter, JdbcType jdbcType) throws SQLException {
        ps.setInt(i, parameter.getValue());
    }

    @Override
    public SexEnum getNullableResult(ResultSet rs, String columnName) throws SQLException {
        return SexEnum.MAP.get(rs.getInt(columnName));
    }

    @Override
    public SexEnum getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        return SexEnum.MAP.get(rs.getInt(columnIndex));
    }

    @Override
    public SexEnum getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        return SexEnum.MAP.get(cs.getInt(columnIndex));
    }
}
