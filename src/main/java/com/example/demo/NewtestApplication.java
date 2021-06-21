package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan(basePackages = { "com.example.demo" })
@EntityScan(basePackages = "com.example.demo.domain")
@EnableTransactionManagement
@EnableJpaRepositories
@SpringBootApplication
public class NewtestApplication {

	public static void main(String[] args) {
		SpringApplication.run(NewtestApplication.class, args);
	}

}
