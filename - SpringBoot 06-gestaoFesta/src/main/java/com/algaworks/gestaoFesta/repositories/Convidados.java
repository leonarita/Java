package com.algaworks.gestaoFesta.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.algaworks.gestaoFesta.models.ConvidadoFesta;

@Repository
public interface Convidados extends JpaRepository<ConvidadoFesta, Long> {
}