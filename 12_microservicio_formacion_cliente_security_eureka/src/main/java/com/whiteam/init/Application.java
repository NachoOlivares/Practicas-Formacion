package com.whiteam.init;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.http.client.support.BasicAuthenticationInterceptor;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication(scanBasePackages = {"com.whiteam.service","com.whiteam.controller"})
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	@LoadBalanced
	@Bean
	public RestTemplate template() {
		RestTemplate template= new RestTemplate();
		template.getInterceptors()
		.add(new BasicAuthenticationInterceptor("user1", "user1"));
		return template;
	}
}
