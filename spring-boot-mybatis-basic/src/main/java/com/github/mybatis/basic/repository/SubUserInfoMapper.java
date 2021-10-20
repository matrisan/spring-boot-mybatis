package com.github.mybatis.basic.repository;

import com.github.mybatis.common.pojo.SubUserInfoDO;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;

/**
 * TODO
 * <p>
 * create in 2021/7/14 9:27 上午
 *
 * @author shishaodong
 * @version 0.0.1
 */
@Mapper
public interface SubUserInfoMapper {

    SubUserInfoDO findById(@Param("id") long id);

    @Insert("INSERT INTO user_info(username, age, sex) VALUES (#{user.username.name},#{user.userAge.age},#{user.userSex, jdbcType=TINYINT, typeHandler=com.github.mybatis.common.config.SexTypeHandler})")
    @Options(useGeneratedKeys = true, keyProperty = "userId", keyColumn = "id")
    long save(@Param("user") SubUserInfoDO subUserInfo);
}
