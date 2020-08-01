package com.eventosapp.SpringSecurity.repository;

import org.springframework.data.repository.CrudRepository;

import com.eventosapp.SpringSecurity.models.Convidado;
import com.eventosapp.SpringSecurity.models.Evento;

public interface ConvidadoRepository extends CrudRepository<Convidado, String>{
	Iterable<Convidado> findByEvento(Evento evento);
	Convidado findByRg(String rg);
}
