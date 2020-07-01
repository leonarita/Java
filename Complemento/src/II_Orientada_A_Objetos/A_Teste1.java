package II_Orientada_A_Objetos;

import II_Orientada_A_Objetos.TV;

public class A_Teste1
{	public static void main (String[] args)
	{
		TV televisao1 = new TV ();
		
		System.out.print ("Esta televisão é da marca " +televisao1.fabricante+ ".  ");
		System.out.print ("A televisão está " +(televisao1.ligado==true? "ligada" : "desligada")+ ".  ");
		System.out.println ("O volume é " +televisao1.volume+ ".");
		
		televisao1.ligar();
		televisao1.aumentarVolume();
		televisao1.aumentarVolume();
		
		System.out.print ("Esta televisão é da marca " +televisao1.fabricante+ ".    ");
		System.out.print ("A televisão está " +(televisao1.ligado==true? "ligada" : "desligada")+ ".   ");
		System.out.print ("O volume é " +televisao1.volume+ ".");
	}
	
}