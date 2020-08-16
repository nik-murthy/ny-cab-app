package com.nycab.redis.api;

import com.nycab.redis.api.client.NyCabCacheImpl;
import com.nycab.redis.api.client.NyCabCacheIntf;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Scope;

@SpringBootApplication
@EnableAutoConfiguration(exclude = DataSourceAutoConfiguration.class)
@ComponentScan(value = {"com.nycab.redis.api", "com.nycab.commons.util"})
public class NyCabRedisApplication {

	public static void main(String[] args) {
		SpringApplication.run(NyCabRedisApplication.class, args);
	}

	@Bean
	@Scope("singleton")
	public NyCabCacheIntf locationCache() {
		return new NyCabCacheImpl();
	}

}
