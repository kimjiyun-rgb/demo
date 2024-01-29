package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

import com.example.demo.component.Game;

//코드 정렬 : 드래그 후 Ctrl + K, F
@Configuration
// 아래 위치를 기준으로 Bean을 생성
// 아래 위치 이하에 존재하는 모든 클래스를 Bean으로 생성
@ComponentScan(basePackages = "com.example.demo.component")
@ImportResource("classpath:application.xml")
public class BeanConfig {
    @Bean
    public String bean1() {
        return new String("Bean 1");
    }

    @Bean
    public Game game() {
        return new Game();
    }
}
