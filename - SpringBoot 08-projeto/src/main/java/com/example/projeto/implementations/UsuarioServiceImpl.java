package com.example.projeto.implementations;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.projeto.entities.Usuario;
import com.example.projeto.repositories.UsuarioRepository;
import com.example.projeto.services.UsuarioService;

@Service
public class UsuarioServiceImpl implements UsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	public Optional<Usuario> buscarPorEmail (String email) {
		return Optional.ofNullable(this.usuarioRepository.findByEmail(email));
	}
}