package com.example.projeto.security;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import com.example.projeto.data.PerfilEnum;
import com.example.projeto.entities.Usuario;

public class JwtUserFactory {

	private JwtUserFactory () { }
	
	// Converte e gera um JwtUser com base nos dados de um funcionário.
	public static JwtUser create (Usuario usuario) {
		return new JwtUser(usuario.getId(), usuario.getEmail(), usuario.getSenha(), mapToGrantedAuthorities(usuario.getPerfil()));
	}
	
	// Converte o perfil do usuário para o formato utilizado pelo Spring Security.
	private static List<GrantedAuthority> mapToGrantedAuthorities (PerfilEnum perfilEnum) {
		
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		authorities.add(new SimpleGrantedAuthority(perfilEnum.toString()));
		
		return authorities;
	}
	
}
