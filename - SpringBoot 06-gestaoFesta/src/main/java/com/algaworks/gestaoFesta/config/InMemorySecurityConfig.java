package com.algaworks.gestaoFesta.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.core.userdetails.User;

@Configuration
public class InMemorySecurityConfig {

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder builder) throws Exception {
		
		builder.inMemoryAuthentication()
			.withUser("joao").password("{noop}123").roles("USER").and()
			.withUser("alexandre").password("{noop}123").roles("USER").and()
			.withUser("thiago").password("{noop}123").roles("USER").and()
			.withUser("admin").password("{noop}admin123").roles("ADMIN");
	}
	
	@SuppressWarnings("deprecation")
	@Bean
    public UserDetailsService userDetailsService() {

        User.UserBuilder users = User.withDefaultPasswordEncoder();
        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
        manager.createUser(users.username("joao").password("123").roles("USER").build());
        manager.createUser(users.username("admin").password("admin123").roles("USER", "ADMIN").build());
        return manager;

    }
}
