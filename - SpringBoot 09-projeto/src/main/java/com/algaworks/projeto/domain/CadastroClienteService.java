package com.algaworks.projeto.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.algaworks.projeto.exceptionhnadler.NegocioException;
import com.algaworks.projeto.models.Cliente;
import com.algaworks.projeto.repositories.ClienteRepository;

@Service
public class CadastroClienteService {

	@Autowired
    private ClienteRepository clienteRepository;
	
	public Cliente salvar(Cliente cliente) {
		Cliente clienteExistente = clienteRepository.findByEmail(cliente.getEmail());
		
		if (clienteExistente != null && !clienteExistente.equals(cliente)) {
			throw new NegocioException("Já existe um cliente cadastrado com este e-mail.");
		}
		
		return clienteRepository.save(cliente);
	}
	
	public void excluir(Long idCliente) {
		clienteRepository.deleteById(idCliente);
	}
}
