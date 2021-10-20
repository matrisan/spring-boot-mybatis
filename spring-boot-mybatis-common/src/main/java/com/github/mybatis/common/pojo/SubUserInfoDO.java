package com.github.mybatis.common.pojo;

import com.github.mybatis.common.pojo.value.Age;
import com.github.mybatis.common.pojo.value.SexEnum;
import com.github.mybatis.common.pojo.value.Username;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

/**
 * TODO
 * <p>
 * create in 2021/7/14 9:25 上午
 *
 * @author shishaodong
 * @version 0.0.1
 */

@Slf4j
@ToString
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SubUserInfoDO {

    Long userId;

    Username username;

    Age userAge;

    SexEnum userSex;

    public SubUserInfoDO(Username username, Age userAge, SexEnum userSex) {
        this.username = username;
        this.userAge = userAge;
        this.userSex = userSex;
    }
}
