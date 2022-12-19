package com.devsuperior.hroauth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class HrOauthApplication {

	//na criação só 2 dependencia depois crio mais Eureka Discovery Client, Sring Web
	//depois colocamos Sring Cloud Security -> Clound OAuth2
	public static void main(String[] args) {
		SpringApplication.run(HrOauthApplication.class, args);
	}

}
