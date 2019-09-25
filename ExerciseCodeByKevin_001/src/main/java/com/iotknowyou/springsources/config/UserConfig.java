package com.iotknowyou.springsources.config;

import com.iotknowyou.springsources.entity.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UserConfig {

    @Bean
    public User newUser(){
        return new User("Kevin","Kevin");
    }

}
