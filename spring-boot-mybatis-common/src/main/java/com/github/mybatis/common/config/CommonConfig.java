package com.github.mybatis.common.config;

import com.github.mybatis.common.init.InitUser;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * TODO
 * <p>
 * create in 2021/7/6 3:35 下午
 *
 * @author shishaodong
 * @version 0.0.1
 */

@Slf4j
@Configuration
public class CommonConfig {

    @Bean
    public InitUser initUser() {
        return new InitUser();
    }


}
