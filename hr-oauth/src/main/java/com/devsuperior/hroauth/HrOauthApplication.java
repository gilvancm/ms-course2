package com.devsuperior.hroauth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@EnableEurekaClient
@SpringBootApplication
public class HrOauthApplication {
	//na aula passada fizemos implementação e a configuração do servidor de Autenticação
	//vamos fazer agora a Autenticação

	//na criação só 2 dependencia depois crio mais Eureka Discovery Client, Sring Web
	//adiciona a dependencia Spring Cloud Routing --> OpenFeingh
	//colocamos Sring Cloud Security -> Clound OAuth2
	//adicionar dependecia --> Spring Boot Actuator e Config Client
	
	public static void main(String[] args) {
		SpringApplication.run(HrOauthApplication.class, args);
	}

}
