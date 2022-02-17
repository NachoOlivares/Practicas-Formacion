package com.whiteam.init;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EntityScan(basePackages = "com.whiteam.model")
//enable annotation for importing dao
@EnableJpaRepositories(basePackages = "com.whiteam.dao")
@SpringBootApplication(scanBasePackages = { "com.whiteam.service", "com.whiteam.controller", "com.whiteam.init" })
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
