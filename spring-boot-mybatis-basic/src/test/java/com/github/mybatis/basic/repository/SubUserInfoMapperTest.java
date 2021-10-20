package com.github.mybatis.basic.repository;

import com.github.mybatis.common.pojo.SubUserInfoDO;
import com.github.mybatis.common.pojo.value.Age;
import com.github.mybatis.common.pojo.value.SexEnum;
import com.github.mybatis.common.pojo.value.Username;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import javax.annotation.Resource;

/**
 * TODO
 * <p>
 * create in 2021/7/16 9:50 上午
 *
 * @author shishaodong
 * @version 0.0.1
 */
@Rollback(value = false)
@SpringBootTest
class SubUserInfoMapperTest {

    @Resource
    private SubUserInfoMapper mapper;

    @Test
    void findById() {
    }

    @Test
    void save() {
        SubUserInfoDO info = new SubUserInfoDO(
                new Username("TEST_NAME"),
                new Age(20),
                SexEnum.FEMALE
        );
        System.out.println(info);
        System.out.println("返回结果:" + mapper.save(info));
        System.out.println(info);
    }
}