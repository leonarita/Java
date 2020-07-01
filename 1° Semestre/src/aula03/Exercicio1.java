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
			
			System.out.print("Considere as op��es abaixo:" + 
					"\n\t1) Arredondar n�mero" + 
					"\n\t2) Arredondar para o pr�ximo inteiro menor" + 
					"\n\t3) Arredondar para o pr�ximo inteiro maior" + 
					"\n\t4) Calcular raiz quadrada" + 
					"\n\t5) Calcular a pot�ncia" +
					"\n\t0) Sair" +
					"\n\nInforme a op��o desejada: ");
			
			op = sc.nextInt();
			
			switch (op)
			{
				case 0:
					System.out.println("\n\nAt� mais!");
					break;
				
				case 1:
					System.out.print("\n\nInforme o n�mero a ser arredondado: ");
					num = sc.nextFloat();
					System.out.print("O n�mero arrendodado � " + Math.round(num));
					break;
					
				case 2:
					System.out.print("\n\nInforme o n�mero a ser arredondado ao inteiro menor: ");
					num = sc.nextFloat();
					System.out.print("O n�mero arrendodado ao inteiro menor � " + Math.floor(num));
					break;
					
				case 3:
					System.out.print("\n\nInforme o n�mero a ser arredondado ao inteiro maior: ");
					num = sc.nextFloat();
					System.out.print("O n�mero arrendodado ao inteiro maior � " + Math.ceil(num));
					break;
					
				case 4:
					System.out.print("\n\nInforme o n�mero a ser calculada a raiz quadrada: ");
					num = sc.nextFloat();
					System.out.print("Sua raiz quadrada � " + Math.sqrt(num));
					break;
					
				case 5:
					System.out.print("\n\nInforme a base: ");
					int base = sc.nextInt();
					System.out.print("Informe o expoente: ");
					int exp = sc.nextInt();
					System.out.print("Sua raiz quadrada � " + Math.pow(base, exp));
					break;
					
				default:
					System.out.println("\n\t\tOp��o inv�lida!");
					break;
			}
			
			if (op==0)
				break;
		}
		while (op != 0);
		
		sc.close();
	}
}