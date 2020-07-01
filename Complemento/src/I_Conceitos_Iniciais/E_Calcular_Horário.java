package I_Conceitos_Iniciais;

import java.util.Scanner;

public class E_Calcular_Horário {
	public static void main(String[] args) {
		 
		 long totalMilisegundos = System.currentTimeMillis();
		 //Método que retorna a quantidade 
		 
		 long totalSegundos = totalMilisegundos / 1000;
		 long segundoAtual = totalSegundos % 60;
		 
		 long totalMinutos = totalSegundos / 60;
		 long minutoAtual = totalMinutos % 60;
		 
		 long totalHora = totalMinutos / 60;
		 long horaAtual = (totalHora % 24) - 3;
		 
		 System.out.println (horaAtual + ":" + minutoAtual + ":" + segundoAtual);
		 
//Verificar se um ano é bissexto
		 Scanner input = new Scanner(System.in);
		 
		 System.out.println("\nInsira um ano:");
		 int ano = input.nextInt();
		 
		 boolean x = (ano % 400 == 0) || (ano % 4 == 0 && ano % 100 != 0);
		 System.out.println(x);
		 
		 input.close();
	}
}