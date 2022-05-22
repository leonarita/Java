package questao3;

import java.util.Scanner;

public class Main {
	
	public static Scanner scanner = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		do {
			int resposta = exibirMenu();
			System.out.println("\n\n");
			
			switch(resposta) {
				case 0:
					System.out.print("Adeus!");
					return;
					
				case 1:
					Menu.adicionarCliente();
					break;
					
				case 2:
					Menu.adicionarChamadaOriginaria();
					break;
					
				case 3:
					Menu.adicionarChamadaRecebida();
					break;
					
				case 4:
					Menu.exibirDadosCliente();
					break;
					
				default:
					break;
			}
		}
		while(true);
	}
	
	private static int exibirMenu() {
		
		try {
			System.out.println("\n\nConsidere as seguintes opções: ");
			
			System.out.println("\t1-Adicionar cliente");
			System.out.println("\t2-Incluir chamada originaria a um cliente");
			System.out.println("\t3-Incluir chamada recebida a um cliente");
			System.out.println("\t4-Exibir os dados de um cliente");
			System.out.println("\t0-Sair");
			
			System.out.print("\t\tInsira a opção desejada: ");
			int n = scanner.nextInt();
			
			if(n < 0 || n > 4)
				throw new NumberFormatException();
			
			scanner.nextLine();
			return n;
		}
		catch(NumberFormatException e) {
			System.out.println("O valor inválido. Por favor, insira novamente.");
			return exibirMenu();
		}
	}

}
