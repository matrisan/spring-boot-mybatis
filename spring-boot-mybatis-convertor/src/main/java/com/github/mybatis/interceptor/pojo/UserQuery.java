package com.github.mybatis.interceptor.pojo;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

/**
 * TODO
 * <p>
 * create in 2021/7/6 5:12 下午
 *
 * @author shishaodong
 * @version 0.0.1
 */

@Slf4j
@Getter
@Setter
public class UserQuery {

    String username;

    Integer startAge;

    Integer endAge;

}
