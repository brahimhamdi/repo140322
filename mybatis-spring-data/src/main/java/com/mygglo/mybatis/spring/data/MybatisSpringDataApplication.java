package com.mygglo.mybatis.spring.data;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mybatis.repository.config.EnableMybatisRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;

@ComponentScan
@EnableMybatisRepositories
@SpringBootApplication
@EnableScheduling
@MapperScan("com.mygglo.mybatis.spring.data.domain.mapper")
public class MybatisSpringDataApplication {

	public static void main(String[] args) {
		SpringApplication.run(MybatisSpringDataApplication.class, args);
	}
}
