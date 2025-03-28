//package com.euroaluAPI.security;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
//import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
//import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.http.SessionCreationPolicy;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.web.SecurityFilterChain;
//import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
//import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
//
//import com.euroaluAPI.AuthTokenFilter;
//import com.euroaluAPI.security.jwt.AuthEntryPoinJwt;
////import com.euroaluAPI.security.jwt.AuthTokenFilter;
//import com.euroaluAPI.services.UserDetailsServiceImpl;
//
//
//
//@Configuration
//@EnableMethodSecurity
//public class WebSecurityConfig {
//	@Autowired
//	UserDetailsServiceImpl userDetailsServiceImpl;
//	
//	@Autowired 
//	private AuthEntryPoinJwt authEntryPoinJwt;
//	
//	@Bean
//	 public AuthTokenFilter authenticationJwtTokenFilter() {
//	    return new AuthTokenFilter();
//	  }
//
//	//  @Override
//	//  public void configure(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {
////	    authenticationManagerBuilder.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
//	//  }
//
//	  @Bean
//	  public DaoAuthenticationProvider authenticationProvider() {
//	      DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
//	       
//	      authProvider.setUserDetailsService(userDetailsServiceImpl);
//	      authProvider.setPasswordEncoder(passwordEncoder());
//	   
//	      return authProvider;
//	  }
//	  
//	//  @Bean
//	//  @Override
//	//  public AuthenticationManager authenticationManagerBean() throws Exception {
////	    return super.authenticationManagerBean();
//	//  }
//	  
//	  @Bean
//	  public AuthenticationManager authenticationManager(AuthenticationConfiguration authConfig) throws Exception {
//	    return authConfig.getAuthenticationManager();
//	  }
//
//	  @Bean
//	  public PasswordEncoder passwordEncoder() {
//	    return new BCryptPasswordEncoder();
//	  }
//
//	//  @Override
//	//  protected void configure(HttpSecurity http) throws Exception {
////	    http.cors().and().csrf().disable()
////	      .exceptionHandling().authenticationEntryPoint(unauthorizedHandler).and()
////	      .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
////	      .authorizeRequests().antMatchers("/api/auth/**").permitAll()
////	      .antMatchers("/api/test/**").permitAll()
////	      .anyRequest().authenticated();
//	//
////	    http.addFilterBefore(authenticationJwtTokenFilter(), UsernamePasswordAuthenticationFilter.class);
//	//  }
//	  
//	  @Bean
//	  public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
////	    http.csrf(csrf -> csrf.disable())
//////	        .exceptionHandling(exception -> exception.authenticationEntryPoint(authEntryPoinJwt))
//////	        .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
////	        .authorizeHttpRequests(auth -> 	
////	          auth.requestMatchers(AntPathRequestMatcher.antMatcher("/admin/auth/**")).permitAll()
////	              .requestMatchers(AntPathRequestMatcher.antMatcher("/api/auth/**")).permitAll()
////	              .requestMatchers(AntPathRequestMatcher.antMatcher("/api/**")).permitAll()
////	              .requestMatchers(AntPathRequestMatcher.antMatcher("/admin/**")).permitAll()
////	              .requestMatchers(AntPathRequestMatcher.antMatcher("/static/**")).permitAll()
////
////
////	              .anyRequest().authenticated()
////	        );
////	    
//////	    http.authenticationProvider(authenticationProvider());
////
//////	    http.addFilterBefore(authenticationJwtTokenFilter(), UsernamePasswordAuthenticationFilter.class);
////	    
////	    return http.build();
//		  http.authorizeHttpRequests(auth -> auth.anyRequest().permitAll());
//		  return http.build();
//	  }
//}
