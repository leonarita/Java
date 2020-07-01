package G_Serializable;

import java.io.Serializable;

public class Department implements Serializable {
	
	//Serialização = Define a versão da API que comporta as classes que serão feitas
	
	public static final long serialVersionUID = 1L; // L = long int
	
	private int id;
	private String nome;
	
	public Department() {
		
	}

	public Department(int id, String nome) {
		this.id = id;
		this.nome = nome;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	//Hashcode and Equals == Impede que haja repetição do valor do id (Como chave primária)

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Department other = (Department) obj;
		if (id != other.id)
			return false;
		return true;
	}

	//toString == SELECT do banco de dados
	@Override
	public String toString() {
		return "Department [id=" + id + ", nome=" + nome + "]";
	}
	
	
	
	
	
	
}