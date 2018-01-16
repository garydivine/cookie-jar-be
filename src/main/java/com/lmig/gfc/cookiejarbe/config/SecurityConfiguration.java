package com.lmig.gfc.cookiejarbe.config;

import java.util.Arrays;

import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import com.lmig.gfc.cookiejarbe.repositories.CookiejarUserDetailsService;

@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	private CookiejarUserDetailsService userDetailsService;

	public SecurityConfiguration(CookiejarUserDetailsService userDetailsService) {
		this.userDetailsService = userDetailsService;
	}

	// Support for CORS
	// Basic Auth

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.cors().and().csrf().disable().authorizeRequests().antMatchers(HttpMethod.GET, "/", "/css/**").permitAll()
				.antMatchers("/api/requests/**").hasRole("ADMIN").anyRequest().authenticated().and().httpBasic();
	}

	// From Invoicify

	// @Override
	// protected void configure(HttpSecurity http) throws Exception {
	// http.authorizeRequests().antMatchers(HttpMethod.GET, "/",
	// "/css/**").permitAll().antMatchers("/admin/**")
	// .hasRole("ADMIN").anyRequest().authenticated().and().formLogin();
	// }

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	CorsConfigurationSource corsConfigurationSource() {
		CorsConfiguration configuration = new CorsConfiguration();
		configuration.setAllowedOrigins(Arrays.asList("*"));
		configuration.setAllowedMethods(Arrays.asList("GET", "POST"));
		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		source.registerCorsConfiguration("/**", configuration);
		return source;
	}

	@Override
	protected UserDetailsService userDetailsService() {
		return userDetailsService;
	}
}
