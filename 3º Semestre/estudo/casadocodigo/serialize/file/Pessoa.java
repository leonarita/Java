package casadocodigo.serialize.file;

import java.io.Serializable;

public class Pessoa implements Serializable {
	
	private String nome;
	
	private String telefone;
	
	// Atributos est�ticos e transients n�o s�o persistidos no arquivo
	
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
