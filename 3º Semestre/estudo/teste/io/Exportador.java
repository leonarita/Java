package teste.io;

import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Exportador {
	
	public static void main(String[] args) throws IOException {
		
		paraCSV(
				new ArrayList<Exportador.Produto>(
						Arrays.asList(
								new Produto("Star Wars", null, 200, "123"),
								new Produto("Harry Potter", "Aventura Mágica", 200, "223")
						)
				)
		);
	}
	
	public static void paraCSV(List<Produto> produtos) throws IOException {
		
		PrintStream ps = new PrintStream("produtos.csv");
		ps.println("Nome; Descricao; Valor; ISBN");
	
		for (Produto produto : produtos) {
			ps.println(String.format("%s; %s; %s; %s", produto.getNome(), produto.getDescricao(), produto.getValor(), produto.getIsbn()));
		}

		ps.close();
	}
	
	public static class Produto implements Comparable<Produto> {
		
		private String nome;
		private String descricao;
		private double valor;
		private String isbn;

		public Produto(String nome, String descricao, double valor, String isbn) {
			super();
			this.nome = nome;
			this.descricao = descricao;
			this.valor = valor;
			this.isbn = isbn;
		}

		public String getNome() {
			return nome;
		}
		
		public String getDescricao() {
			return descricao;
		}
		
		public double getValor() {
			return valor;
		}

		public String getIsbn() {
			return isbn;
		}

		@Override
		public int compareTo(Produto o) {
			return this.isbn == o.getIsbn() ? 1 : 0;
		}
	}

}
