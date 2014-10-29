package com.mohitkanwar.qbank.common.service.impl;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional(readOnly=true)
public class CustomUserDetailsService implements UserDetailsService {
	
	@Transactional
	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException {
				return null;
		
	}
	
	public Collection<? extends GrantedAuthority> getAuthorities(Integer userId) {
		return null;
		
	}
	public boolean registerNewUser(String username,String password){
		return false;
		
	}
}