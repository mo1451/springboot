package com.mo1451.boot;

import org.springframework.amqp.core.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class JdbcmybatisApplication {

	public static void main(String[] args) {
		SpringApplication.run(JdbcmybatisApplication.class, args);
	}
}
