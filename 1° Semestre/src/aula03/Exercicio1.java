package aula03;

import java.util.Scanner;

public class Exercicio1 
{
	public static void main(String[] args) 
	{	Scanner sc = new Scanner(System.in);
		
		int op=1;
		float num;
	
		do
		{
			System.out.println("\n\n\n");
			
			System.out.print("Considere as opções abaixo:" + 
					"\n\t1) Arredondar número" + 
					"\n\t2) Arredondar para o próximo inteiro menor" + 
					"\n\t3) Arredondar para o próximo inteiro maior" + 
					"\n\t4) Calcular raiz quadrada" + 
					"\n\t5) Calcular a potência" +
					"\n\t0) Sair" +
					"\n\nInforme a opção desejada: ");
			
			op = sc.nextInt();
			
			switch (op)
			{
				case 0:
					System.out.println("\n\nAté mais!");
					break;
				
				case 1:
					System.out.print("\n\nInforme o número a ser arredondado: ");
					num = sc.nextFloat();
					System.out.print("O número arrendodado é " + Math.round(num));
					break;
					
				case 2:
					System.out.print("\n\nInforme o número a ser arredondado ao inteiro menor: ");
					num = sc.nextFloat();
					System.out.print("O número arrendodado ao inteiro menor é " + Math.floor(num));
					break;
					
				case 3:
					System.out.print("\n\nInforme o número a ser arredondado ao inteiro maior: ");
					num = sc.nextFloat();
					System.out.print("O número arrendodado ao inteiro maior é " + Math.ceil(num));
					break;
					
				case 4:
					System.out.print("\n\nInforme o número a ser calculada a raiz quadrada: ");
					num = sc.nextFloat();
					System.out.print("Sua raiz quadrada é " + Math.sqrt(num));
					break;
					
				case 5:
					System.out.print("\n\nInforme a base: ");
					int base = sc.nextInt();
					System.out.print("Informe o expoente: ");
					int exp = sc.nextInt();
					System.out.print("Sua raiz quadrada é " + Math.pow(base, exp));
					break;
					
				default:
					System.out.println("\n\t\tOpção inválida!");
					break;
			}
			
			if (op==0)
				break;
		}
		while (op != 0);
		
		sc.close();
	}
}