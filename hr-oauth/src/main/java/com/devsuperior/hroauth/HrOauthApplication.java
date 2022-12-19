package com.devsuperior.hroauth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HrOauthApplication {

	//na criação só 2 dependencia depois crio mais Eureka Discovery Client, Sring Web
	//depois colocamos Sring Cloud Security -> Clound OAuth2
	public static void main(String[] args) {
		SpringApplication.run(HrOauthApplication.class, args);
	}

}
