package I_Conceitos_Iniciais;

import java.util.Scanner;

public class F_Strings {
	public static void main(String[] args){
		
/*		String nome = "P�o com mortadela";
		System.out.println(nome);			*/
		 
		Scanner input = new Scanner(System.in);
		 
		System.out.print("Informe seu primeiro nome: ");
		String primeiroNome = input.next();
		 
		System.out.print("Informe seu �ltimo nome: ");
		String ultimoNome = input.next();
		 
		System.out.print("Informe sua idade: ");
		int idade = input.nextInt();
		 
		System.out.println("\nOl�, " + primeiroNome + " " + ultimoNome + ", cuja idade � " + idade + " anos!");
		 
		
		 if(idade < 1)
		 {	System.out.println("\tIdade informada n�o � v�lida.");				}
		 else if(idade < 18)
		 {	System.out.println ("\t" + primeiroNome + " � menor de idade.");	} 
		 else 
		 {	System.out.println ("\t" + primeiroNome + " � maior de idade.");	}

		 input.close();
	}
}
