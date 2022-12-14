package com.devsuperior.hrpayroll.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devsuperior.hrpayroll.entities.Payment;
import com.devsuperior.hrpayroll.services.PaymentService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

//recurso web disponibilidade para testar na web
//caminho
//criamos um endpoint
	//rota é o complemento do caminho e parametro {workerId} e {days}

//o caminho /payments
@RestController
@RequestMapping(value = "/payments")
public class PaymentResource {
	
	@Autowired
	private PaymentService service;
	
	//na chamada do metodo láno hr-worker o @hystrixCommand
	
	//end pointe e a Rota /{workerId}/days/{days} e o parametro {workerId} e {days}
	//chamo um metodo novo getPaymentAlternative
	@HystrixCommand(fallbackMethod = "getPaymentAlternative")
	@GetMapping(value = "/{workerId}/days/{days}")
	public ResponseEntity<Payment> getPayment(@PathVariable Long workerId, @PathVariable Integer days) {
		Payment payment = service.getPayment(workerId, days);
		return ResponseEntity.ok(payment);
	}	
	
	//metodo alternativo se dé errado
	
	public ResponseEntity<Payment> getPaymentAlternative(Long workerId, Integer days) {
		Payment payment = new Payment("Gilvan Muniz MOCK", 400.0, days);
		return ResponseEntity.ok(payment);
	}
	
	
	
}







