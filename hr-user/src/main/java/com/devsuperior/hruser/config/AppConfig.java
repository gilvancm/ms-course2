package com.devsuperior.hruser.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
public class AppConfig {

	//a instancia que vou gerar com este metodo possa ser injetada no Spring
	@Bean
	public BCryptPasswordEncoder passowordEncoder() {
		return new BCryptPasswordEncoder();
	}
}
