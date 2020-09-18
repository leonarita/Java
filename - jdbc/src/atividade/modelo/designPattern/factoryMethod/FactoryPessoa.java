package atividade.modelo.designPattern.factoryMethod;

import atividade.modelo.Pessoa;
import atividade.modelo.PessoaFisica;
import atividade.modelo.PessoaJuridica;

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
	
	public static Pessoa escolherContaPorCredencial (String credencial) {
		if (credencial.length() == 11)
			return new PessoaFisica();
		else if (credencial.length() == 14)
			return new PessoaJuridica();
		return null;
	}
}
