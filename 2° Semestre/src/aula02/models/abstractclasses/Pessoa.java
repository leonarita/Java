package aula02.models.abstractclasses;

import java.util.Date;

public abstract class Pessoa {
	
	protected long cpf;
	protected String nome;
	protected String sobrenome;
	protected String login;
	protected String email;
	protected String senha;
	protected Date nascimento;
	
	public Pessoa() {
	}

	public Pessoa(long cpf, String nome, String sobrenome, String login, String email, String senha, Date nascimento) {
		this.cpf = cpf;
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.login = login;
		this.email = email;
		this.senha = senha;
		this.nascimento = nascimento;
	}

	public long getCpf() {
		return cpf;
	}

	public void setCpf(long cpf) {
		this.cpf = cpf;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Date getNascimento() {
		return nascimento;
	}

	public void setNascimento(Date nascimento) {
		this.nascimento = nascimento;
	}

}
