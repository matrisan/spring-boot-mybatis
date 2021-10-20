package com.github.mybatis.interceptor.repository;

import com.github.mybatis.interceptor.pojo.UserInfoDO;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author 石少东
 * @date 2020-12-03 14:49
 * @since 1.0
 */


public interface IUserInfoRepository extends JpaRepository<UserInfoDO, Long> {
}
