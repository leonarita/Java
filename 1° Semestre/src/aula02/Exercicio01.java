package aula02;

import java.util.Scanner;

public class Exercicio01 {
	
	public static void main (String[] args)
	{
		System.out.print("\n\nInforme um n�mero inteiro: ");
		Scanner scan = new Scanner(System.in);
		int num = scan.nextInt();
		
		if (num%2==0)
			System.out.println("O n�mero " + num + " � par");
		else
			System.out.println("O n�mero " + num + " � �mpar");
		
		scan.close();
	}
}
