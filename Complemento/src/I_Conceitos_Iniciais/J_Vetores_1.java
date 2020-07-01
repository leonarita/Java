package I_Conceitos_Iniciais;

import java.util.Scanner;

public class J_Vetores_1 {
	 public static void main(String[] args){
		 
		 Scanner input = new Scanner(System.in);
		 
		 int numAlunos = 5;
		 double[] notaAlunos = new double[numAlunos];
		 
	/*	 notaAlunos[0] = 6.7;
		 notaAlunos[1] = 5.7;
		 notaAlunos[2] = 7.8;	*/
		 
		 for(int i = 0; i < numAlunos; ++i)
		 {	System.out.println("Insira a nota do " + (i+1) + "° aluno: ");
		 	notaAlunos[i] = input.nextDouble();			}
		 
		 for(int i = 0; i < numAlunos; ++i)
		 	System.out.println("Nota do "+(i+1)+"° aluno: " + notaAlunos[i]);	
		 
		 input.close();
	}
}