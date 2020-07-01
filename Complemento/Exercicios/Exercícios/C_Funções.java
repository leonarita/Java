package Exercícios;

public class C_Funções 
{
	public static void main (String[] args)
	{
		try
		{
			C_Funções func = new C_Funções();
			System.out.println(func.tamanho("Bom diaaaa"));
			System.out.println(func.helloWorld("Bom diaaaa"));
			System.out.println(func.calculo(23f, 7f, 33.2f));
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
	
	private String helloWorld(String str)
	{
		return "A palavra possui " + str.length() + " caracteres.";
	}
	
	private float calculo (float x, float y, float z)
	{
		return (((x + y) * x) / z);
	}

	private int tamanho (String str)
	{
		return str.length();
	}
}