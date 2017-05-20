package org.eagle.journal.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.EnableGlobalAuthentication;

//@Configuration
//@EnableGlobalAuthentication
public class InMemorySecurityConfiguration {

	//@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception{
		auth.inMemoryAuthentication().withUser("user").password("iamgood").roles("USER");
		auth.inMemoryAuthentication().withUser("admin").password("admin").roles("USER", "ADMIN");
	}
	
}
