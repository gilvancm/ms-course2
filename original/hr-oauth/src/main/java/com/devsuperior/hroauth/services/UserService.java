package com.devsuperior.hroauth.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.devsuperior.hroauth.entities.User;
import com.devsuperior.hroauth.feignclients.UserFeignClient;


//vamos criar uma cominicação entre os serviços  -->  UserService
@Service
public class UserService implements UserDetailsService {

	private static Logger logger = LoggerFactory.getLogger(UserService.class);
	
	@Autowired
	private UserFeignClient userFeignClient;
	
	public User findByEmail(String email) {
		//aqui fazemos a comunicação par buscar as informações
		User user = userFeignClient.findByEmail(email).getBody();
		if(user == null) {
			
			logger.error("Email no found: " + email);
			throw new IllegalArgumentException("Email no found:");
			
		}
		logger.info("Email found: " + email);
		return user;
		
	}

	//o metodo certo é esse abaixo pelo sring security, o decima só para aula
	//esse maetodo loadUserByUsername que vai ter a autorização e o token
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		User user = userFeignClient.findByEmail(username).getBody();
		if(user == null) {
			
			logger.error("Email no found: " + username);
			throw new UsernameNotFoundException("Email no found:");
			
		}
		logger.info("Email found: " + username);
		return user;
		
		
		
	}
	
}
