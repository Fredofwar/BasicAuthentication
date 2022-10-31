package com.example.curso.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;

/**
 * 
 * @author armentaja
 * WebSecurityConfigurerAdapter está obsoleto
 * Esto está bien con Spring Security versión 5.6.5 o anterior, o con Spring Boot versión 
 * 2.6.8 o anterior. Sin embargo, si su proyecto usa Spring Security 5.7.1 o posterior, o 
 * Spring Boot 2.7.0 o posterior, recibirá esta advertencia en su IDE:
	El tipo WebSecurityConfigurerAdapter está obsoleto
 */
@SuppressWarnings("deprecation")
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Autowired
	public void configureGlobalSecurity(AuthenticationManagerBuilder auth) throws Exception{
		auth.inMemoryAuthentication().withUser("fredward").password("123456").roles("ADMIN");
		auth.inMemoryAuthentication().withUser("user").password("user").roles("USER");
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception{
		http.csrf().disable().authorizeRequests()
		.antMatchers("/todos_profesores_public").permitAll()
		.antMatchers("/todos_profesores_admin").hasRole("ADMIN")
		.antMatchers("/todos_profesores_user").hasRole("USER")
		.antMatchers("/*/escribirBD/**").hasRole("ADMIN")//Da acceso a el rol ADMIN al endpoint que tenga escribirBD
		.and()
		.httpBasic();
	}
	
	@SuppressWarnings("deprecation")
	@Bean
	public static NoOpPasswordEncoder passwordEncoder() {
		return (NoOpPasswordEncoder) NoOpPasswordEncoder.getInstance();
	}
	
}
