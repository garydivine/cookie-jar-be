package com.lmig.gfc.cookiejarbe.config;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.lmig.gfc.cookiejarbe.repositories.CookiejarUserDetailsService;

@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	private CookiejarUserDetailsService userDetailsService;

	public SecurityConfiguration(CookiejarUserDetailsService userDetailsService) {
		this.userDetailsService = userDetailsService;
	}

	// @Override
	// protected void configure(HttpSecurity http) throws Exception {
	// http.authorizeRequests().antMatchers(HttpMethod.GET, "/",
	// "/css/**").permitAll().antMatchers("/api/recipes/**")
	// .hasRole("ADMIN").anyRequest().authenticated();
	// }

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/api/recipes/**").permitAll();
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Override
	protected UserDetailsService userDetailsService() {
		return userDetailsService;
	}
}
