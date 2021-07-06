package com.github.mybatis.common.init;


import com.github.mybatis.common.repository.IUserInfoRepository;
import com.github.mybatis.common.pojo.UserInfoDO;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author 石少东
 * @date 2020-12-03 14:45
 * @since 1.0
 */


@Component
public class InitUser implements CommandLineRunner {

    @Resource
    private IUserInfoRepository repository;

    @Override
    public void run(String... args) {
        if (repository.count() == 0) {
            for (int i = 0; i < 10; i++) {
                UserInfoDO save = repository.save(UserInfoDO.builder().username("name:" + i).age(i).build());
                System.out.println(save);
            }
        }
    }
}
