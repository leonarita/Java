package _Orientação_A_Objetos;

public class Aula9
{	public static void main (String args[])
	{	String arr[] = new String[10];
		arr[0] = "Palavra";
		String palavra = " "; 	//a variável palavr" será usada no banner
		
		//se o usuário digitou uma palavra
		if (arr.length > 0)
		{	System.out.println ("Mostra a palavra letra a letra");
			System.out.println("Para encerrar pressiona CRTL+C");
			
			palavra = arr[0];	//a variável recebe a palavra digitada
			
			while (true)		//looping infinito
			{
				for (int i=0; i<palavra.length(); i++)		//varre os caracteres da palavra
				{	System.out.println (palavra.charAt(i));
					for (int x=0; x<50000000; x++);			//temporizador 1
				}
				
				System.out.println ( );
				for (int y=0; y<10000000; y++);			//temporizador 2
			}
		}
		else
			System.out.println ("Entre com uma palavra qualquer");
	}
}
