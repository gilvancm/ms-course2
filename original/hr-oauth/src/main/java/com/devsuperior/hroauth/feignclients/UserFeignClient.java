package com.devsuperior.hroauth.feignclients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.devsuperior.hroauth.entities.User;

//uma coisa é a autenticação(saber os dados do usuario se existe) a outra coisa é autorização
//fazemos a class de comunicação entre hr-oauth com o hr-user com UserFeighClient
//cominicação com hr-user e o caminho /users
@Component
@FeignClient(name = "hr-user", path = "/users")
public interface UserFeignClient {

	@GetMapping(value = "/search") 
	public ResponseEntity<User> findByEmail(@RequestParam String email);
	
}
