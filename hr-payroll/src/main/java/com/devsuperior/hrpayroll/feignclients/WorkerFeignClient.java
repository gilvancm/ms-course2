package com.devsuperior.hrpayroll.feignclients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.devsuperior.hrpayroll.entities.Worker;

//@FeignClient(name = "hr-worker", url = "localhost:8001", path = "/workers")
//coloquei o nome do prjeto, e hadcode o endereço e o caminho
@Component
@FeignClient(name = "hr-worker", path = "/workers")
public interface WorkerFeignClient {
	
	//vou trazer a assinatura do resource do Worker
	//o tipo de chamada que ela vai fazerno webserver
	@GetMapping(value = "/{id}")
	public ResponseEntity<Worker> findById(@PathVariable Long id);
}
