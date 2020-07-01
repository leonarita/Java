package I_Conceitos_Iniciais;

import java.util.Scanner;

public class F_Strings {
	public static void main(String[] args){
		
/*		String nome = "Pão com mortadela";
		System.out.println(nome);			*/
		 
		Scanner input = new Scanner(System.in);
		 
		System.out.print("Informe seu primeiro nome: ");
		String primeiroNome = input.next();
		 
		System.out.print("Informe seu último nome: ");
		String ultimoNome = input.next();
		 
		System.out.print("Informe sua idade: ");
		int idade = input.nextInt();
		 
		System.out.println("\nOlá, " + primeiroNome + " " + ultimoNome + ", cuja idade é " + idade + " anos!");
		 
		
		 if(idade < 1)
		 {	System.out.println("\tIdade informada não é válida.");				}
		 else if(idade < 18)
		 {	System.out.println ("\t" + primeiroNome + " é menor de idade.");	} 
		 else 
		 {	System.out.println ("\t" + primeiroNome + " é maior de idade.");	}

		 input.close();
	}
}
