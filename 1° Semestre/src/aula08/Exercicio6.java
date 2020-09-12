package aula08;

import java.util.ArrayList;
import java.util.Comparator;

public class Exercicio6 {
	
	public static class Pessoa {
		private String nome;
		private String sobrenome;
		
		public Pessoa(String nome, String sobrenome) {
			super();
			this.nome = nome;
			this.sobrenome = sobrenome;
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

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Pessoa other = (Pessoa) obj;
			if (nome == null) {
				if (other.nome != null)
					return false;
			} else if (!nome.equals(other.nome))
				return false;
			if (sobrenome == null) {
				if (other.sobrenome != null)
					return false;
			} else if (!sobrenome.equals(other.sobrenome))
				return false;
			return true;
		}
	}
	
	// Interfaces Comparable, Comparator => Implementadas

	public static void main(String[] args) {
		
		Pessoa p1 = new Pessoa("Ana", "Banana");
		Pessoa p2 = new Pessoa("Carla", "Banana");
		Pessoa p3 = new Pessoa("Ana", "Banana");
		
		ArrayList<Pessoa> a = new ArrayList<>();
		a.add(p2);
		a.add(p1);
		
		// Sem equals => Compara instâncias
		// Com equals => Compara a lógica do método equals
		System.out.println(a.contains(p1));
		System.out.println(a.contains(p3));
		System.out.println();
		
		for(Pessoa p : a) {
			System.out.println("\t" + p.getNome());
		} 
		
		System.out.println();
		a.sort(Comparator.comparing(Pessoa::getNome));

		for(Pessoa p : a) {
			System.out.println("\t" + p.getNome());
		} 
	}

}
