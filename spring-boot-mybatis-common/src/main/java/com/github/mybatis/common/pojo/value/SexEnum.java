package com.github.mybatis.common.pojo.value;

import lombok.Getter;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * TODO
 * <p>
 * create in 2021/7/14 9:46 上午
 *
 * @author shishaodong
 * @version 0.0.1
 */

public enum SexEnum {

    /**
     * 男
     */
    MALE(1),
    /**
     * 女
     */
    FEMALE(0);

    @Getter
    private final Integer value;

    SexEnum(int point){
        this.value = point;
    }

    public static final Map<Integer, SexEnum> MAP = Arrays.stream(SexEnum.values())
            .collect(Collectors.toMap(SexEnum::getValue, one -> one));

}
