package com.github.mybatis.convertor.init;


import com.github.mybatis.convertor.pojo.BookValue;
import com.github.mybatis.convertor.pojo.UserInfoDO;
import com.github.mybatis.convertor.repository.IUserInfoRepository;
import net.bytebuddy.utility.RandomString;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Collections;

/**
 * @author 石少东
 * @date 2020-12-03 14:45
 * @since 1.0
 */


@Component
public class InitUser implements ApplicationRunner {

    @Resource
    private IUserInfoRepository repository;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        if (repository.count() == 0) {
            for (int i = 0; i < 10; i++) {
                UserInfoDO save = repository.save(UserInfoDO.builder().username("name:" + i).age(i)
                        .books(Collections.singletonList(new BookValue(RandomString.make(5))))
                        .build());
                System.out.println(save);
            }
        }
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
    }
}
