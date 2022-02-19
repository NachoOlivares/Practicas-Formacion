package com.whiteam.init;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.http.client.support.BasicAuthenticationInterceptor;
import org.springframework.web.client.RestTemplate;

@EntityScan(basePackages = "com.whiteam.model")
@SpringBootApplication(scanBasePackages = {"com.whiteam.service", "com.whiteam.controller"})
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	//Imprescindible para usar restTemplate
	@Bean
	public RestTemplate template() {
		//Interceptor para pasar clave y contraseña entre microservices
		RestTemplate template = new RestTemplate();
		//Interceptores se van a ejecutar cada vez que reciben una peticion externa
		//Este en concreto esta preparado para añadir usuario y clave para autorizacion
		template.getInterceptors().add(new BasicAuthenticationInterceptor("user1", "user1"));
		return template;
	}
}
