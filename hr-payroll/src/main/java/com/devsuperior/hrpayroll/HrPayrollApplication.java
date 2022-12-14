package com.devsuperior.hrpayroll;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableCircuitBreaker
@EnableEurekaClient
@EnableFeignClients
@SpringBootApplication
public class HrPayrollApplication {

	public static void main(String[] args) {
		SpringApplication.run(HrPayrollApplication.class, args);
	}

}

/*
vamos incluir o primeirocomponente de Spring Clound 
para a comunicação do projeto é o Feign e ele vai tar 
integrada como outras ferramentas do Spring Clound
vamosacresentar na dependencia Feign do Spring Clound Rounting que é OpenFeign
para Feing funcionar vamos ter de criar uma interface com as assinaturas
*/

//obs ainda não é microserviço e só uma cominicação entre os projetos
//sendo hadcode
/* anotação acresentei na dependencia Spring Web, Feign que é o OpenFeign, Ribbon , EurekaClient é (Eureka Discovery Client)
* Hystrix que é no Spring Cçound Circuit Breaker o (Hystrix[Maintenence])
*/



