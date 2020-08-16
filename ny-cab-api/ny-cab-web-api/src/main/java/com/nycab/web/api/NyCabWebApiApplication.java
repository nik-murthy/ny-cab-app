package com.nycab.web.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
@ComponentScan(value = {"com.nycab.web.api", "com.nycab.commons.util"})
public class NyCabWebApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(NyCabWebApiApplication.class, args);
	}

}
