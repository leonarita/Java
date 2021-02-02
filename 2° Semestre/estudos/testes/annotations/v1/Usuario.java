package testes.annotations.v1;

import java.time.LocalDate;

public class Usuario {
	
	@Length(max = 20, min = 5, rules = { "contains ' '", "at least 2 words" })
	private String nome;

	@CPF
	private String cpf;

	@IdadeMinima(valor = 18)
	private LocalDate dataNascimento;
	
	public Usuario(String nome, String cpf, LocalDate dataNascimento) {
		this.nome = nome;
		this.cpf = cpf;
		this.dataNascimento = dataNascimento;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	
	

}
