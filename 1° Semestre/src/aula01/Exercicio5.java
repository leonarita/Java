package aula01;

public class Exercicio5 {

	/*Fazer debug
		- ctrl shift b : inclui/remove breakpoint
		- F5 : fluxo entra no método
		- F6 : fluxo não entra no método
		- F7 : fluxo sai do método
		- F8 : executa até proximo breakpoint
	*/
	
	public static void main(String[] args) {

		String[] alunos = { "João", "Maria", "Pedro", "Ana", "Carlos" };
		
		System.out.println("Lista de Alunos: ");
		imprimeVetor(alunos);
		
		System.out.println("\n\nVocê imprimiu todos os nomes!");
	}
	
	public static void imprimeVetor (String[] nomes) {
		
		for (int i=0; i<nomes.length; i++)
			System.out.println("\t" + (i+1) + "- " + nomes[i]);
	}

}
