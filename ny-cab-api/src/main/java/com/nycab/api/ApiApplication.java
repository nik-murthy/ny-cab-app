package com.nycab.api;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ApiApplication {

	public static void main(String[] args) {

//		HikariConfig hikariConfig = new HikariConfig("/hikari.properties");
//		HikariDataSource hikariDataSource = new HikariDataSource(hikariConfig);
		SpringApplication.run(ApiApplication.class, args);
	}

}
