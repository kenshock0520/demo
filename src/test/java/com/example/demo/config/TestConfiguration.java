package com.example.demo.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@ComponentScan(basePackages = "com.example.demo")
@Profile("test")
public class TestConfiguration {

	// ここにMockのBeanが必要な場合もあると思います
//
//    @Bean
//    public XXX xxx() {
//        return mock(XXX.class);
//    }

}