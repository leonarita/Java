package Exerc�cios;

import java.util.Scanner;

public class B_Pot�ncia
{
	public static double fat (int num)
	{	if (num==0)
			return 1;
		else
			return num * fat(num-1);
	}
	
	public static void main (String[] args)
	{	Scanner input = new Scanner (System.in);
	
		System.out.print ("Digite um n�mero: ");
		int num = input.nextInt();
		
		double result = fat(num);
		System.out.print ("O fatorial de " +num+ " � igual a " +result);
		
		input.close();
	}

}