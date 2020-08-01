package com.example.projeto.implementations;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.projeto.entities.Usuario;
import com.example.projeto.security.JwtUserFactory;
import com.example.projeto.services.UsuarioService;

@Service
public class JwtUserDetailsServiceImpl implements UserDetailsService {
	
	@Autowired
	private UsuarioService usuarioService ;
	
	@Override
	public UserDetails loadUserByUsername (String username) throws UsernameNotFoundException {
		
		Optional<Usuario> funcionario = usuarioService.buscarPorEmail(username);
	
		if (funcionario.isPresent()) {
			return JwtUserFactory.create(funcionario.get());
		}
	
		throw new UsernameNotFoundException("Email não encontrado.");
	}

}
