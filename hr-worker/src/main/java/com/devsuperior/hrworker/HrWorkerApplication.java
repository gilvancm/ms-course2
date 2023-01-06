package com.devsuperior.hrworker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
@EnableEurekaClient
@SpringBootApplication
public class HrWorkerApplication {

	public static void main(String[] args) {
		SpringApplication.run(HrWorkerApplication.class, args);
	}

	/* anotação acresentei na dependencia Spring Data JPA, H2 Database, 
	 * Spring Web, EurekaClient é (Eureka Discovery Client)
	 * adicionei agora a dependencia  Config Client
	 * biblioteca Ops (Spring Boot Actuator)
	 * * adicionei agora a dependencia postgres
	*/
	
}
