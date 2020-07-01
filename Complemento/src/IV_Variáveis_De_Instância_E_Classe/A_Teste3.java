package IV_Variáveis_De_Instância_E_Classe;

import IV_Variáveis_De_Instância_E_Classe.Exemplo;

public class A_Teste3 {
	public static void main (String[] args)
	{
		Exemplo ex1 = new Exemplo();
		System.out.println (ex1.x);
		
		Exemplo ex2 = new Exemplo();
		System.out.println (ex2.x);
/*
		if (ex1.y== ex2.y)
			System.out.println("Prosseguindo..");
*/
	}
}