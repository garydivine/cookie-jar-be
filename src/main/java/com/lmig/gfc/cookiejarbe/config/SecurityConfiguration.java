package com.lmig.gfc.cookiejarbe.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	private UserDetailsService userDetailsService;

	public SecurityConfiguration(UserDetailsService userDetailsService) {
		this.userDetailsService = userDetailsService;
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.cors().and().authorizeRequests()
				// allow access without auth to the following routes
				.antMatchers(HttpMethod.GET, "/img/**", "/css/**", "/js/**", "/api/**").permitAll()
				.antMatchers(HttpMethod.DELETE, "/api/users/new", "/api/**").permitAll()
				.antMatchers(HttpMethod.POST, "/api/users/new", "/api/**").permitAll()
				.antMatchers(HttpMethod.PUT, "/api/session/mine", "/api/**").permitAll().antMatchers(HttpMethod.OPTIONS)
				.permitAll().anyRequest().authenticated().and().csrf().disable();
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Override
	public UserDetailsService userDetailsService() {
		return userDetailsService;
	}

}