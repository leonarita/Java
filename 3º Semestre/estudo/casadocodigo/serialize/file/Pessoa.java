package casadocodigo.serialize.file;

import java.io.Serializable;

public class Pessoa implements Serializable {
	
	private String nome;
	
	private String telefone;
	
	// Atributos estáticos e transients não são persistidos no arquivo
	
	public Pessoa() {
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getTelefone() {
		return telefone;
	}
	
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

}
