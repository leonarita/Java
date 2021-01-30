package modelo.repositorio.interfaces;

import java.util.Set;

import modelo.Pessoa;
import modelo.repositorio.PessoaRepository;

public interface PessoaInterface {
	
	PessoaRepository pessoaRepository = new PessoaRepository();
	
	default Set<Pessoa> findAll() {
		return pessoaRepository.recuperarPessoas();
	}

}
