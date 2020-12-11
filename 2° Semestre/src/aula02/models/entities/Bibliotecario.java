package aula02.models.entities;

import java.util.Date;

import aula02.models.abstractclasses.Pessoa;

public class Bibliotecario extends Pessoa {
	
	private Date dataAdmissao;
	private int idFuncionario;
	
	public Bibliotecario() {
	}

	public Bibliotecario(long cpf, String nome, String sobrenome, String login, String email, String senha, Date nascimento, Date dataAdmissao, int idFuncionario) {
		super(cpf, nome, sobrenome, login, email, senha, nascimento);
		this.dataAdmissao = dataAdmissao;
		this.idFuncionario = idFuncionario;
	}

	public Date getDataAdmissao() {
		return dataAdmissao;
	}

	public void setDataAdmissao(Date dataAdmissao) {
		this.dataAdmissao = dataAdmissao;
	}

	public int getIdFuncionario() {
		return idFuncionario;
	}

	public void setIdFuncionario(int idFuncionario) {
		this.idFuncionario = idFuncionario;
	}

}
