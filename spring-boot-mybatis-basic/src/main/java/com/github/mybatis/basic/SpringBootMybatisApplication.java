package com.github.mybatis.basic;

import com.github.mybatis.common.repository.IUserInfoRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * TODO
 * <p>
 * create in 2021/7/6 3:21 下午
 *
 * @author shishaodong
 * @version 0.0.1
 */
@SpringBootApplication
@EntityScan("com.github.mybatis")
@EnableJpaRepositories(basePackageClasses = IUserInfoRepository.class)
public class SpringBootMybatisApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootMybatisApplication.class, args);
    }

}
