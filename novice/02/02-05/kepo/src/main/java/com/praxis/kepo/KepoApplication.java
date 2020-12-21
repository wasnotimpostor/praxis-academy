package com.praxis.kepo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@EnableJpaRepositories //(basePackages = "com.praxis.kepo")
@SpringBootApplication (exclude = {DataSourceAutoConfiguration.class })
public class KepoApplication {
	public static void main(String[] args) {
		SpringApplication.run(KepoApplication.class, args);
	}

}
