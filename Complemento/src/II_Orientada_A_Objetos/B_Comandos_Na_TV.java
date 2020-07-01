package II_Orientada_A_Objetos;

import java.util.Scanner;

import II_Orientada_A_Objetos.TV;

public class B_Comandos_Na_TV
{	public static void main (String[] args)
	{
		TV televisao1 = new TV ();
		Scanner input = new Scanner(System.in);
		
		System.out.print ("Esta televisão é da marca " +televisao1.fabricante+ ".  ");
		System.out.print ("A televisão está " +(televisao1.ligado==true? "ligada" : "desligada")+ ".  ");
		System.out.println ("O volume é " +televisao1.volume+ ".");
		
		System.out.println ("\n\nConsidere os seguintes comando do controle remoto: ");
		System.out.println ("\tLigar/Desligar: 1-Ligar 0-Desligar");
		System.out.println ("\nDeseja Ligar a tv? ");
		int a = input.nextInt();
		
		String c;
		
		do {
			System.out.println ("\tVolume: +)Aumentar -)Diminuir");
			System.out.println ("\nDeseja alterar o volume? ");
			String b = input.nextLine();
			
			if (a==1)
				televisao1.ligar();
			else if (a==0)
				televisao1.desligar();
			
			if (b=="+")
				televisao1.aumentarVolume();
			else if (b=="-")
				televisao1.diminuirVolume();
			
			System.out.println ("\tDeseja continuar usando o controle remoto (sim/não)? ");
			c = input.nextLine();
			
		} while (c=="sim" && c=="Sim");
		
		System.out.print ("Esta televisão é da marca " +televisao1.fabricante+ ".    ");
		System.out.print ("A televisão está " +(televisao1.ligado==true? "ligada" : "desligada")+ ".   ");
		System.out.print ("O volume é " +televisao1.volume+ ".");
		
		input.close();
	}
}