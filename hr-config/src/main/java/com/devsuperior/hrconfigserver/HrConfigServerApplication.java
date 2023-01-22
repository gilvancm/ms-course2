package com.devsuperior.hrconfigserver;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
//temos que incluir a dependencia Config Sever
//este aplicativo busca no github a configuração de cada microserviço

@EnableConfigServer
@SpringBootApplication
public class HrConfigServerApplication implements CommandLineRunner {

	// pego o valor de uma variavel de ambiente externa
	@Value("${spring.cloud.config.server.git.username}")
	private String username;

	@Value("${spring.cloud.config.server.git.password}")
	private String password;

	public static void main(String[] args) {
		SpringApplication.run(HrConfigServerApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// mostrono console o valor da variavelde ambiente no console, para testar se
		// deu certo a busca
		// depois de testar eu grifo
		System.out.println("USERNAME = " + username);
		System.out.println("");
		System.out.println("PASSWORD = " + password);

	}

}
