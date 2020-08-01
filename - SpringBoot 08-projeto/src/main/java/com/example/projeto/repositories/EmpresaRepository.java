package com.example.projeto.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.projeto.entities.Empresa;

public interface EmpresaRepository extends JpaRepository < Empresa , Long > {
	Empresa findByCnpj ( String cnpj );
}