package com.algaworks.projeto.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.algaworks.projeto.models.Comentario;

@Repository
public interface ComentarioRepository extends JpaRepository<Comentario, Long> {
}
