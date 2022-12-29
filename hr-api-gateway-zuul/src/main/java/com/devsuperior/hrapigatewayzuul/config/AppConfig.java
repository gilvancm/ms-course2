package com.devsuperior.hrapigatewayzuul.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

@Configuration
public class AppConfig {

	//vamos criar 2 @Bean componentes para trabalhar com JWT, segurança 
	//1 componente cria uma chave para o token
	//criamos este objeto JwtAccessTokenConverter
	@Bean
	public JwtAccessTokenConverter accessTokenConverter() {
		    //pegamos o objeto JwtAccessTokenConverter
		JwtAccessTokenConverter tokenConverter = new JwtAccessTokenConverter();
		    //vamos criar a chave secreta de assinar com o token
	    	//por enquando vou criar uma chave HadCode, depois vamos pagar do nosso servidor centralizado
    	tokenConverter.setSigningKey("MY-SECRET-KEY");
    	return tokenConverter;
	}
	
	//esso objeto JwtTokenStore vai ser responsavel de ler as informações do token
	@Bean
	public JwtTokenStore jwtTokenStore() {
		return new JwtTokenStore(accessTokenConverter());
	}

	
	
}
