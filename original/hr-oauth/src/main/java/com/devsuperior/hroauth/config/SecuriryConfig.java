package com.devsuperior.hroauth.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

//na class SecuriryConfig ele vai autenticar recebe as credências do usuario com as informaçoes e vai no banco e checa
// se é verdadeira para poder autorizar ai devouver o token.
//impelemento com o framwork
@Configuration
public class SecuriryConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	@Autowired
	private UserDetailsService userDetailsService;

	//chamo a Override/implementação/metodo
	@Override
	@Autowired
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		// aqui fazemos a comparação
		auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder);
	}

	//implementei na aula passada
		//chamo a Override/implementação/metodo
	//lembrar colocar o @Bean
	
	@Override
	@Bean
	protected AuthenticationManager authenticationManager() throws Exception {
		// a resultado vai ser o que tá ai abaixo
		return super.authenticationManager();
	}
	
}
