package com.Veera_Sathvik.AMS.configuarations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableMethodSecurity
public class SecurityConfig {
	private UserDetailsService userDetailsService;
	public SecurityConfig(UserDetailsService userDetailsService){
		this.userDetailsService = userDetailsService;
	}

	//Password Encryption
	@Bean
	public static PasswordEncoder passwordEncoder(){
		return new BCryptPasswordEncoder();
	}

	@Bean
	public AuthenticationManager authenticationManager(AuthenticationConfiguration configuration) throws Exception {
		return configuration.getAuthenticationManager();
	}

	//Authorization Mapping
	@Bean
	SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http.csrf(AbstractHttpConfigurer::disable)
		.authorizeHttpRequests((authorize) ->
		//authorize.anyRequest().authenticated()
		authorize//.requestMatchers(HttpMethod.GET, "/api/**").permitAll()
		.requestMatchers("/swagger-ui/**","/swagger-resources/*","/v3/api-docs/**").permitAll()
		.requestMatchers("/api/auth/**").permitAll()
		.requestMatchers("/api/ams/v1/admin/**").hasRole("ADMIN")
		.requestMatchers("/api/ams/v1/manager/**").hasRole("MANAGER")
		.anyRequest().authenticated()
				);
		return http.build();

	}

	public UserDetailsService getUserDetailsService() {
		return userDetailsService;
	}

	public void setUserDetailsService(UserDetailsService userDetailsService) {
		this.userDetailsService = userDetailsService;
	}
}

