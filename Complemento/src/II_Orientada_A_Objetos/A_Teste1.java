package II_Orientada_A_Objetos;

import II_Orientada_A_Objetos.TV;

public class A_Teste1
{	public static void main (String[] args)
	{
		TV televisao1 = new TV ();
		
		System.out.print ("Esta televis�o � da marca " +televisao1.fabricante+ ".  ");
		System.out.print ("A televis�o est� " +(televisao1.ligado==true? "ligada" : "desligada")+ ".  ");
		System.out.println ("O volume � " +televisao1.volume+ ".");
		
		televisao1.ligar();
		televisao1.aumentarVolume();
		televisao1.aumentarVolume();
		
		System.out.print ("Esta televis�o � da marca " +televisao1.fabricante+ ".    ");
		System.out.print ("A televis�o est� " +(televisao1.ligado==true? "ligada" : "desligada")+ ".   ");
		System.out.print ("O volume � " +televisao1.volume+ ".");
	}
	
}