package aula01;

import java.util.Scanner;

public class Exercicio4 {

	public static void main(String[] args) {

		int qtd=3;
		
		Scanner sc = new Scanner (System.in);
		
		String[] nome = new String[qtd];
		String[] descricao = new String[qtd];
		float[] preco = new float[qtd];
		
		for (int i=0; i<qtd; i++)
		{
			System.out.print("Informe o nome do " + (i+1) + "� produto: ");
			nome[i] = sc.nextLine();
			
			System.out.print("Informe a descri��o do " + (i+1) + "� produto: ");
			descricao[i] = sc.nextLine();
			
			System.out.print("Informe o pre�o do " + (i+1) + "� produto: ");
			preco[i] = sc.nextFloat();
			
			System.out.println("\n\n");
			sc.nextLine();
		}
		
		System.out.print("Informe o pre�o m�ximo para pesquisa de produtos: ");
		float p = sc.nextFloat();
		System.out.println("\n\n");
		
		for (int i=0; i<qtd; i++)
		{
			if (preco[i] <= p)
			{
				System.out.println("Nome: " + nome[i] + ", Descri��o: " + descricao[i] + ", Pre�o: R$" + preco[i]);
			}
		}
		
		sc.close();
	}
}
