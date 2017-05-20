package org.eagle.journal.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;


@Configuration
@EnableAuthorizationServer
@EnableResourceServer
public class ResourceSecurityConfiguration extends ResourceServerConfigurerAdapter{
	/*  
	 * WebSecurityConfigurerAdapter  - this adapter has to be used when we are securing a server 
	 * by regular means that is basic, inmemory or jdbc auth provider 
	 * in the case of OAuth2 we need ResourceServerConfigurerAdapter
	 */
  
	@Override
	public void configure(HttpSecurity http) throws Exception{
		http.authorizeRequests().antMatchers("/").permitAll()
		    .antMatchers("/api/*").authenticated();
		    //.and().httpBasic();
	}
	
}
