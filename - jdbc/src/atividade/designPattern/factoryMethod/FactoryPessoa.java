package atividade.designPattern.factoryMethod;

import atividade.modelo.Pessoa;
import atividade.modelo.PessoaFisica;
import atividade.modelo.PessoaJuridica;
import atividade.modelo.enumeration.SituacaoPessoaEnum;

public class FactoryPessoa {

	public static Pessoa criarPessoa(int op, String nome, String endereco, long cep, String telefone, double renda) {
		
		if (op == SituacaoPessoaEnum.PESSOAFISICA.getSituacao())
			return new PessoaFisica(nome, endereco, cep, telefone, renda);
		else if (op == SituacaoPessoaEnum.PESSOAJURIDICA.getSituacao())
			return new PessoaJuridica(nome, endereco, cep, telefone, renda);
		return null;
	}
	
	public static Pessoa criarPessoa(int op) {

		if (op == SituacaoPessoaEnum.PESSOAFISICA.getSituacao())
			return new PessoaFisica();
		else if (op == SituacaoPessoaEnum.PESSOAJURIDICA.getSituacao())
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
