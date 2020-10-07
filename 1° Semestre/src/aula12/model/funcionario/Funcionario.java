package aula12.model.funcionario;
import java.math.BigDecimal;

import aula12.model.cargo.Cargo;

// Classe de domínio da entidade Funcionario.
// Juntas, as classes de domínio modelam a estrutura de negócio da aplicação.
// Possuem basicamente atributos e seus respectivos métodos get e set, 
// usados para recuperação e atribuição de valores aos seus dados.

// DICA: Para criar automaticamente os métodos get e set para os atributos da classe, no editor 
// de código, clique com o botão direito do mouse no código >> Source >> Generate Getters and Setters.

public class Funcionario {
	int idFuncionario;
	String nome;
	char sexo;
	BigDecimal salario; 
	boolean planoSaude;
	Cargo cargo;
	
	public void setIdFuncionario(int idFuncionario) {
		this.idFuncionario = idFuncionario;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public void setSexo(char sexo) {
		this.sexo = sexo;
	}
	public void setSalario(BigDecimal salario) {
		this.salario = salario;
	}
	public void setPlanoSaude(boolean planoSaude) {
		this.planoSaude = planoSaude;
	}
	public void setCargo(Cargo cargo) {
		this.cargo = cargo;
	}
	
	
	public int getIdFuncionario() {
		return idFuncionario;
	}
	public String getNome() {
		return nome;
	}
	public char getSexo() {
		return sexo;
	}
	public BigDecimal getSalario() {
		return salario;
	}
	public boolean isPlanoSaude() {
		return planoSaude;
	}
	public Cargo getCargo() {
		return cargo;
	}
}