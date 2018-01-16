package com.lmig.gfc.cookiejarbe.repositories;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.lmig.gfc.cookiejarbe.models.User;

@Service
public class CookiejarUserDetailsService implements UserDetailsService {

	private UserRepository userRepository;

	public CookiejarUserDetailsService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepository.findByName(username);
		if (user == null) {
			throw new UsernameNotFoundException(username);
		}
		return user;
	}

}