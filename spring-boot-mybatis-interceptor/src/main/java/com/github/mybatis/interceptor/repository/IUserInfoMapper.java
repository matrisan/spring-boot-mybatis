package com.github.mybatis.interceptor.repository;

import com.github.mybatis.interceptor.pojo.UserInfoDO;
import com.github.mybatis.interceptor.pojo.UserQuery;
import lombok.val;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;

import java.util.List;

/**
 * TODO
 * <p>
 * create in 2021/7/6 5:02 下午
 *
 * @author shishaodong
 * @version 0.0.1
 */
@Mapper
public interface IUserInfoMapper {

    @Select("SELECT * FROM user_info WHERE id = #{id}")
    UserInfoDO selectFromUserInfoByUserId(@Param("id") long id);

    @SelectProvider(type = SqlBuilder.class, method = "buildSql")
    List<UserInfoDO> findAll(UserQuery query);

    class SqlBuilder {
        public String buildSql(UserQuery query) {
            val sql = new StringBuilder();
            sql.append("select * from user_info where 1 = 1");
            if (StringUtils.isNoneBlank(query.getUsername())) {
                sql.append(" and username like ").append(query.getUsername()).append("%'");
            }
            if (ObjectUtils.isNotEmpty(query.getStartAge())) {
                sql.append(" and age > ").append(query.getStartAge());
            }
            if (ObjectUtils.isNotEmpty(query.getEndAge())) {
                sql.append(" and age < ").append(query.getEndAge());
            }
            return sql.toString();
        }
    }
}
