package com.bookstore.config;

import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

/**
 * Created by Dominik on 29.04.2017.
 */
@EnableRedisHttpSession
public class HttpSessionConfig {

    @Bean
    LettuceConnectionFactory connectionFactory(){
        return new LettuceConnectionFactory();
    }
}