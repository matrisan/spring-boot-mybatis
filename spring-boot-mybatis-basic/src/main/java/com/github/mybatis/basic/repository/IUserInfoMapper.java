package com.github.mybatis.basic.repository;


import com.github.mybatis.common.pojo.UserInfoDO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * @author 石少东
 * @date 2020-12-03 14:40
 * @since 1.0
 */

@Mapper
public interface IUserInfoMapper {

    @Select("SELECT * FROM user_info WHERE id = #{id}")
    UserInfoDO selectFromUserInfoByUserId(@Param("id") long id);

//    @Options(useGeneratedKeys = true, keyProperty = "id")
//    @Insert("INSERT INTO user_info VALUES(#{})")
//    int insertUserInfo(UserInfoDO userInfo);
//
//    @Update("UPDATE user_info set username = #{username} WHERE id = #{id}")
//    int updateUserInfo(UserInfoDO userInfo);
//
//    @Delete("DELETE FROM user_info WHERE id=#{id}")
//    int deleteById(int id);

}
