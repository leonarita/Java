package Exercícios;

import java.util.Scanner;

public class A_Matriz 
{	public static void main (String[] args)
	{	int i=3, j=3;
		double[][] matriz = new double[i][j];
		double somaTotal=0;
		Scanner input = new Scanner (System.in);
		
		for (i=0; i<3; i++)
		{	for (j=0; j<3; j++)
			{	System.out.print("Insira o valor da matriz["+(i+1)+"]["+(j+1)+"]: ");
				matriz[i][j] = input.nextDouble();
				somaTotal += matriz[i][j];
			}
		}
		
		double diagonalPrincipal  = matriz[0][0] + matriz[1][1] + matriz[2][2];
		double diagonalSecundária = matriz[0][2] + matriz[1][1] + matriz[2][0];
		
		double det = (matriz[0][0] * matriz[1][1] * matriz[2][2]) + (matriz[0][1] * matriz[1][2] * matriz[2][0]) + (matriz[0][2] * matriz[1][0] * matriz[2][1]) - (matriz[0][2] * matriz[1][1] * matriz[2][0]) - (matriz[2][1] * matriz[1][2] * matriz[0][0]) - (matriz[2][2] * matriz[0][1] * matriz[1][0]);
				
		System.out.println ("\n\n\t\t M A T R I Z \n");
		System.out.println ("           |  Linha 1  |  Linha 2  |  Linha 3  |");
		System.out.println ("-----------|-----------|-----------|-----------|");
		System.out.println ("Coluna 1   |    " +matriz[0][0]+ "    |    " +matriz[0][1]+ "    |    " +matriz[0][2]+ "    |");
		System.out.println ("Coluna 2   |    " +matriz[1][0]+ "    |    " +matriz[1][1]+ "    |    " +matriz[1][2]+ "    |");
		System.out.println ("Coluna 3   |    " +matriz[2][0]+ "    |    " +matriz[2][1]+ "    |    " +matriz[2][2]+ "    |");
		
		System.out.println ("\n\nO determinante da matriz é " + det);
		System.out.println ("A soma dos elementos da diagonal principal é " + diagonalPrincipal);
		System.out.println ("A soma dos elementos da diagonal secundária é " + diagonalSecundária);
		System.out.println ("A soma de todos os valores da matriz é " + somaTotal);
		
		input.close();
	}
}