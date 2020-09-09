package atividade_DataPersistence.modelo.designPattern.factoryMethod;

import atividade_DataPersistence.modelo.Pessoa;
import atividade_DataPersistence.modelo.PessoaFisica;
import atividade_DataPersistence.modelo.PessoaJuridica;

public class FactoryPessoa {

	public static Pessoa criarPessoa(int op, String nome, String endereco, long cep, String telefone, double renda) {
		if (op == 1)
			return new PessoaFisica(nome, endereco, cep, telefone, renda);
		else if (op == 2)
			return new PessoaJuridica(nome, endereco, cep, telefone, renda);
		return null;
	}
	
	public static Pessoa criarPessoa(int op) {
		if (op == 1)
			return new PessoaFisica();
		else if (op == 2)
			return new PessoaJuridica();
		return null;
	}
}
