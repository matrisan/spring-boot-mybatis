package com.github.mybatis.basic.controller;

import com.github.mybatis.basic.repository.SubUserInfoMapper;
import com.github.mybatis.common.pojo.SubUserInfoDO;
import com.github.mybatis.common.pojo.UserInfoDO;
import com.github.mybatis.common.pojo.value.Age;
import com.github.mybatis.common.pojo.value.SexEnum;
import com.github.mybatis.common.pojo.value.Username;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * TODO
 * <p>
 * create in 2021/7/14 10:29 上午
 *
 * @author shishaodong
 * @version 0.0.1
 */
@RestController
public class SubUserInfoController {

    @Resource
    private SubUserInfoMapper mapper;

    @GetMapping("/mybatis/{id}")
    public SubUserInfoDO findSubById(@PathVariable long id) {
        return this.mapper.findById(id);
    }

    @PostMapping("/mybatis")
    public long save(@RequestBody UserInfoDO user) {
        return mapper.save(new SubUserInfoDO(new Username(user.getUsername()), new Age(user.getAge()), SexEnum.MALE));
//        return new SubUserInfoDO();
    }
}
