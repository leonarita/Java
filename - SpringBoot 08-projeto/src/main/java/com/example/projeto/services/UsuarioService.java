package com.example.projeto.services;

import java.util.Optional;

import com.example.projeto.entities.Usuario;

public interface UsuarioService {

	Optional<Usuario> buscarPorEmail ( String email );
}
