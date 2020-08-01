package com.eventosapp.SpringSecurity.repository;

import org.springframework.data.repository.CrudRepository;

import com.eventosapp.SpringSecurity.models.Evento;

public interface EventoRepository extends CrudRepository<Evento, String>{
	Evento findByCodigo(long codigo);
}
