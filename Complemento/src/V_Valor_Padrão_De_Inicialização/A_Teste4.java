package V_Valor_Padr�o_De_Inicializa��o;

import V_Valor_Padr�o_De_Inicializa��o.Exemplo;

public class A_Teste4 
{	public static void main (String[] args)
	{
		Exemplo ex1 = new Exemplo();
		
		System.out.println ("byte = " + ex1.a);
		System.out.println ("short = " + ex1.b);
		System.out.println ("int = " + ex1.c);
		System.out.println ("long = " + ex1.d);
		System.out.println ("float = " + ex1.e);
		System.out.println ("double = " + ex1.f);
		System.out.println ("char = " + ex1.g);
		System.out.println ("boolean = " + ex1.h);
		System.out.println ("objeto = " + ex1.i);
		
		ex1.abc();
	}

}