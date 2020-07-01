package _Orientação_A_Objetos;

public class Aula6
{
	public static int somar(int n1, int n2)
	{	return(n1+n2);	}
	
	public static void main (String args[])
	{	int a=10;
		int b=20;
		System.out.println(a + " + " + b + " = "+ somar(a,b) );
	}
}