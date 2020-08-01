package com.eventosapp.SpringSecurity;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class SpringSecurityApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringSecurityApplication.class, args);
		
		//Será imprimido uma criptografia da senha "123" que deverá ser colocada no BD, mas, no login, vai ser necessário apenas o "123"
		System.out.print(new BCryptPasswordEncoder().encode("123"));
	}

}
