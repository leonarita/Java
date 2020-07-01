package aula01;

public class Exercicio5 {

	/*Fazer debug
		- ctrl shift b : inclui/remove breakpoint
		- F5 : fluxo entra no m�todo
		- F6 : fluxo n�o entra no m�todo
		- F7 : fluxo sai do m�todo
		- F8 : executa at� proximo breakpoint
	*/
	
	public static void main(String[] args) {

		String[] alunos = { "Jo�o", "Maria", "Pedro", "Ana", "Carlos" };
		
		System.out.println("Lista de Alunos: ");
		imprimeVetor(alunos);
		
		System.out.println("\n\nVoc� imprimiu todos os nomes!");
	}
	
	public static void imprimeVetor (String[] nomes) {
		
		for (int i=0; i<nomes.length; i++)
			System.out.println("\t" + (i+1) + "- " + nomes[i]);
	}

}
