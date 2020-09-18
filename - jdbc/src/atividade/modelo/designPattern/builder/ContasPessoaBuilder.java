package atividade.modelo.designPattern.builder;

import java.util.ArrayList;
import java.util.List;

import atividade.modelo.ContaComum;
import atividade.modelo.Pessoa;

public class ContasPessoaBuilder {

	private Pessoa pessoa;
	private List<ContaComum> contas;
	
	public ContasPessoaBuilder() {
		pessoa = new Pessoa();
		contas  = new ArrayList<>();
	}

	public ContasPessoaBuilder(Pessoa pessoa, List<ContaComum> contas) {
		this.pessoa = pessoa;
		this.contas = contas;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(String nomePessoa, String enderecoPessoa, long cepPessoa, String telefonePessoa, double rendaPessoa, int situacaoPessoa) {
		this.pessoa.setNomePessoa(nomePessoa);
		this.pessoa.setEnderecoPessoa(enderecoPessoa);
		this.pessoa.setCepPessoa(cepPessoa);
		this.pessoa.setTelefonePessoa(telefonePessoa);
		this.pessoa.setRendaPessoa(rendaPessoa);
		this.pessoa.setSituacaoPessoa(situacaoPessoa);
	}
	
	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public List<ContaComum> getContas() {
		return contas;
	}

	public void setContas(List<ContaComum> contas) {
		this.contas = contas;
	}
	
}
