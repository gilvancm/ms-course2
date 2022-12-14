package com.devsuperior.hrpayroll.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class AppConfig {
 
	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
	/*
	temos que fazer uma chamada rest para API do worker
	vamos ter que criar um Bean objeto é uma instancia unica
	que fica disponivel para o nosso projeto
	vamos ter que criar uma classe de configuração
	para disponibilizar as instancia a classe AppConfig
	cria umainstancia unica o sing que fica disponivel 
	para toda solução
	*/
	
}
