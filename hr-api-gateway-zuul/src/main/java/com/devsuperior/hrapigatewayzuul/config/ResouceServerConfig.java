package com.devsuperior.hrapigatewayzuul.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

@Configuration
@EnableResourceServer
public class ResouceServerConfig extends ResourceServerConfigurerAdapter{

	//injetar o token
		@Autowired
		private JwtTokenStore tokenStore;
	
		//autorização e rota vai ter o perfil 
		private static final String[] PUBLIC = { "/hr-oauth/oauth/token" };
		
		private static final String[] OPERATOR = { "/hr-worker/**" };
		
		private static final String[] ADMIN = { "/hr-payroll/**", "/hr-user/**" };
	
	//clicar com a direita source -> Override imol metodo
	@Override
	public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
				//super.configure(resources);
		// aqui consegue ler o token
		resources.tokenStore(tokenStore);
	}
	
	//aqui e o cara que vai configurar as autorizações é o metodo HttpSecurity
	//vou criar variaveis static acima para não poluir no metodo abaixo
	@Override
	public void configure(HttpSecurity http) throws Exception {
				//super.configure(http);
		// definir as autorizações
		
		http.authorizeRequests()
		.antMatchers(PUBLIC).permitAll()
		.antMatchers(HttpMethod.GET, OPERATOR).hasAnyRole("OPERATOR", "ADMIN")
		.antMatchers(ADMIN).hasRole("ADMIN")
		.anyRequest().authenticated();
	}
	
}
