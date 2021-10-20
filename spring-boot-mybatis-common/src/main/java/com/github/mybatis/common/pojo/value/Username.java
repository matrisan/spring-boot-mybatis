package com.github.mybatis.common.pojo.value;

import lombok.Value;
import lombok.extern.slf4j.Slf4j;

import java.io.Serializable;

/**
 * TODO
 * <p>
 * create in 2021/7/14 9:23 上午
 *
 * @author shishaodong
 * @version 0.0.1
 */

@Slf4j
@Value
public class Username implements Serializable {

    String name;
}
