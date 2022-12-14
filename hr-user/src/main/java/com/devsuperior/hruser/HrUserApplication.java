package com.devsuperior.hruser;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

// adicionei agora a dependencia  Config Client
// biblioteca Ops (Spring Boot Actuator)
//adicionar a dependencia postgres

@EnableEurekaClient
@SpringBootApplication
public class HrUserApplication implements CommandLineRunner{

	//trago da class AppConfig atravez do Bean
    @Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	public static void main(String[] args) {
		SpringApplication.run(HrUserApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// Bcrypt rest retona o valor ou numenro criptografado
		//ele gera o BCRYPT da senha o algaritmi BCRYPT , cada vez gera uma cominação diferente 
		System.out.println("BCRYPT = " + passwordEncoder.encode("lucas"));
	}

}
