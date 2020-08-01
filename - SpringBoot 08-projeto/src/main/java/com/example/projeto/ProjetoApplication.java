package com.example.projeto;

import java.util.TimeZone;

import javax.annotation.PostConstruct;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

//import com.example.projeto.config.SenhaUtils;

@SpringBootApplication
public class ProjetoApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjetoApplication.class, args);
		
		//System.out.print(new BCryptPasswordEncoder().encode("123456"));
		
		//String senhaEncoded = SenhaUtils.gerarBCrypt("123456");
		//boolean senhaValida = SenhaUtils.senhaValida("123456", senhaEncoded);
		
		//System.out.println(SenhaUtils.gerarBCrypt("123456"));
		//System.out.println(SenhaUtils.senhaValida("123456", senhaEncoded));
	}
	
	@PostConstruct
    void init(){
		TimeZone.setDefault(TimeZone.getTimeZone("GMT-0300"));
    }

}
