package com.algaworks.projeto.controllers;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.algaworks.projeto.domain.CadastroClienteService;
import com.algaworks.projeto.models.Cliente;
import com.algaworks.projeto.repositories.ClienteRepository;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteRepository clienteRepository;
    
    @Autowired
    private CadastroClienteService cadastroCliente;

    @GetMapping
    public List<Cliente> listar() {

        return clienteRepository.findAll();

        //return clienteRepository.findByNome("João");
        //return clienteRepository.findByNomeContaining("Jo");
    }

    @GetMapping("/{clienteId}")
    public ResponseEntity<Cliente> buscar(@PathVariable Long clienteId) {

        Optional<Cliente> cliente = clienteRepository.findById(clienteId);
        //return cliente.orElse(null);

        if(cliente.isPresent()) {
            //resposta 200
            return ResponseEntity.ok(cliente.get());
        }

        //resposta 404
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Cliente adicionar(@Valid @RequestBody Cliente cliente) {
        // Resposta 201
        return cadastroCliente.salvar(cliente);
    }

    @PutMapping("/{clienteId}")
    public ResponseEntity<Cliente> atualizar(@Valid @PathVariable Long clienteId, @RequestBody Cliente cliente) {

        if(!clienteRepository.existsById(clienteId)) {
            return ResponseEntity.notFound().build();
        }

        cliente.setId(clienteId);
        cliente = cadastroCliente.salvar(cliente);

        return ResponseEntity.ok(cliente);
    }

    @SuppressWarnings("unchecked")
	@DeleteMapping("/{clienteId}")
    public ResponseEntity<Void> remover(@PathVariable Long clienteId) {

        if(!clienteRepository.existsById(clienteId)) {
            return ResponseEntity.notFound().build();
        }

        cadastroCliente.excluir(clienteId);

        //resposta 204
        return (ResponseEntity<Void>) ResponseEntity.noContent();
    }

    //resposta 400 : erro do cliente
    //resposta 500 : erro do servidor

}
