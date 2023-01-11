package com.devsuperior.hrworker.resources;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devsuperior.hrworker.entities.Worker;
import com.devsuperior.hrworker.repositories.WorkerRepository;

//@RefreshScope faz parte da biblioteca Ops (Spring Boot Actuator)
 
@RefreshScope
@RestController
@RequestMapping(value = "/workers")
public class WorkerResource {
	//mostrar loguin
	private static Logger logger = LoggerFactory.getLogger(WorkerResource.class);
	
	//pegar no github o nome da configuração a variavel
	/*
	@Value("${test.config}")
	private String testConfig;
	*/
	//mostra informações caracteristica interna
	@Autowired
	private Environment env;
	
	@Autowired
	private WorkerRepository repository;
	
	// EndPoint 0 end point de buscar a configuração no github e ver se o consolo tá lendo o valor
		@GetMapping(value = "/configs")
		public ResponseEntity<Void> getConfigs() {
			//vou imprimir no log
		//	logger.info("CONFIG = " + testConfig);
			return ResponseEntity.noContent().build();
		}
	
	
	
	// EndPoint 1
	@GetMapping
	public ResponseEntity<List<Worker>> findAll() {
		List<Worker> list = repository.findAll();
		return ResponseEntity.ok(list);
	}	
	
	// EndPoint 2
	@GetMapping(value = "/{id}")
	public ResponseEntity<Worker> findById(@PathVariable Long id) {
		// 1 - simular um erro aqui no endpoint vou fazer umagabiarra e testar com uma exceção
		/*
		int x = 1;
		if(x == 1)
		      throw new RuntimeException("teste");
		*/
		// 2 - simulaçao testando com 3 milisegundos
		//vai estourar o timeoutdo Ribbon, o tempo do balenceamento de carga é 1000L e ai não  faz a chamada ai cai
		//sempre vai estourar o timeout
		// se tiver na propriedade do hr-payrooll da certo os 3000L
		/*
		 //testando o tempo
		try {
			Thread.sleep(3000L); //3 segundo  e o tempo padrão do ribbon é 1 segundo 
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		*/
		
		//mostra inormação e a porta que tá acessando
		logger.info("PORT = " + env.getProperty("local.server.port"));
		
		Worker obj = repository.findById(id).get();
		return ResponseEntity.ok(obj);
	}	
}
