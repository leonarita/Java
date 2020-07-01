package I_Conceitos_Iniciais;

import java.util.Scanner;

public class D_Operador_Resto {
	 public static void main(String[] args){
		 
		 Scanner input = new Scanner(System.in);
		 
		 System.out.println("insira um valor em gramas: ");
		 int gramas = input.nextInt();
		 
		 int kilos = gramas / 1000;
		 gramas = gramas % 1000;
		 
		 System.out.println("O total de kilos é = "+ kilos);
		 System.out.println("O total de gramas é = "+ gramas);
		 
		 input.close();
	 }
}

//Comandos iguais à Linguagem C
	// 1) IF ELSE
	// 2) WHILE
	// 3) DO WHILE
	// 4) FOR
	// 5) SWITCH CASE