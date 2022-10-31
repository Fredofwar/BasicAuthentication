package com.example.curso.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

//@EnableWebSecurity
//@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true, jsr250Enabled = true)
//@Configuration
/***
 * 
 * @author armentaja
 * Esta clase es para basic authentication versiones 2.7 en adelante basada en componentes
 * https://www.baeldung.com/spring-deprecated-websecurityconfigureradapter
 */
public class SecurityConfiguration { 
	/**
	@Bean
	public UserDetailsService userDetailsService(BCryptPasswordEncoder bCryptPasswordEncoder) {
	    InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
	    manager.createUser(User.withUsername("user")
	      .password(bCryptPasswordEncoder.encode("userPass"))
	      .roles("USER")
	      .build());
	    manager.createUser(User.withUsername("admin")
	      .password(bCryptPasswordEncoder.encode("adminPass"))
	      .roles("ADMIN")
	      .build());
	    return manager;
	}
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
	    http.csrf()
	      .disable()
	      .authorizeRequests()
	      .antMatchers(HttpMethod.DELETE)
	      .hasRole("ADMIN")
	      .antMatchers("/todos_profesores_public").permitAll()
	      .antMatchers("/todos_profesores_admin").hasAnyRole("ADMIN")
	      .antMatchers("/todos_profesores_user").hasAnyRole("USER")
	      //.antMatchers("/login/**").anonymous()
	      .anyRequest()
	      .authenticated()
	      .and()
	      .httpBasic()
	      .and()
	      .sessionManagement()
	      .sessionCreationPolicy(SessionCreationPolicy.STATELESS);

	    return http.build();
	}
	
	@Bean
	public WebSecurityCustomizer webSecurityCustomizer() {
	    return (web) -> web.debug(false)
	      .ignoring()
	      .antMatchers("/css/**", "/js/**", "/img/**", "/lib/**", "/favicon.ico");
	}**/
}
