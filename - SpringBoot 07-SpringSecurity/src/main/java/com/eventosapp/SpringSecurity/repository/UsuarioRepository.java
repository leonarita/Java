package com.eventosapp.SpringSecurity.repository;

import org.springframework.data.repository.CrudRepository;

import com.eventosapp.SpringSecurity.models.Usuario;

public interface UsuarioRepository extends CrudRepository<Usuario, String>{

	Usuario findByLogin(String login);
}
