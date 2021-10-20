package com.github.mybatis.interceptor;

import com.github.mybatis.interceptor.pojo.UserInfoDO;
import com.github.mybatis.interceptor.pojo.UserQuery;
import com.github.mybatis.interceptor.repository.IUserInfoMapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.Resource;

/**
 * <p>
 * create in 2021/7/6 3:21 下午
 *
 * @author shishaodong
 * @version 0.0.1
 */
@SpringBootApplication
public class SpringBootMybatisApplication implements CommandLineRunner {

    @Resource
    private IUserInfoMapper mapper;

    @Override
    public void run(String... args) throws Exception {
        UserInfoDO userInfoDO = mapper.selectFromUserInfoByUserId(1L);
        System.out.println(userInfoDO);
        System.out.println();
        UserQuery query = new UserQuery();
        query.setUsername("");
        query.setStartAge(5);
        query.setEndAge(8);
        mapper.findAll(query).forEach(System.out::println);
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringBootMybatisApplication.class, args);
    }

}
