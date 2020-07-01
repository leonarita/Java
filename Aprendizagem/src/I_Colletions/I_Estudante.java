package I_Colletions;

public class I_Estudante implements Comparable<I_Estudante> {
	
	private final String nome;
	private final Integer idade;
	
	public I_Estudante (String nome, Integer idade) {
		this.nome = nome;
		this.idade = idade;
	}

	public String getNome() {
		return nome;
	}

	public Integer getIdade() {
		return idade;
	}
	
	@Override
	public String toString() {
		return nome + " - " + idade;
	}

	@Override
	public int compareTo(I_Estudante o) {
		return this.getIdade() - o.getIdade();
	}
}