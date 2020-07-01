package aula02;

import java.util.Scanner;

public class Exercicio03 
{
	public static void main (String[] args)
	{
		System.out.println("aaasss");
		Scanner sc = new Scanner (System.in);
		float[] faturamento = new float[12];
		float result=0;
		
		for (int i=0; i<=11; i++)
		{	System.out.print("Informe o faturamento do " + (i+1) + "° mês: ");
			faturamento[i] = sc.nextFloat();
			result += faturamento[i];
		}
		
		sc.close();
		
		if (result<=50000.00)
			System.out.println("Faturamento foi baixo!");
		else if (result>=50000.01 && result<=100000.00)
			System.out.println("Faturamento foi médio!");
		else
			System.out.println("Faturamento foi alto!");
	}

}
