//package com.euroaluAPI.services;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
//import com.euroaluAPI.models.Account;
//import com.euroaluAPI.repositories.AccountRepository;
//
//import jakarta.transaction.Transactional;
//
//@Service
//public class UserDetailsServiceImpl implements UserDetailsService {
//	@Autowired
//	AccountRepository accountRepository;
//	
//	@Override
//	@Transactional
//	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//		Account account = accountRepository.findByUsername(username)
//				.orElseThrow(() -> new UsernameNotFoundException("User Not Found with username: " + username));
//		
//		return UserDetailsImpl.buildA(account);
//	}
//
//}
