package _Orientação_A_Objetos;

//Exemplo de método sem retorno de valor.

public class Aula4 
{
	//Método titulo, não devolve valor e não necessita de objetos para ser acionado. Tem uma String que não pode ser altera da como parâmetro.
	//Passar o texto TESTE para servir como título do programa - centralizado

	static void titulo (final String texto)
	{	int brancos = (80-texto.length())/2;
		for (int i = 1; i <= brancos; i++)
		System.out.print(' ');
		System.out.println(texto);
	}
	
	//O método main, não devolve valor, não necessita de objetos para ser acionado e pode ser invocado livremente. Tem uma matriz de String como parâmetro

	public static void main (String args[])
	{	try
		{	titulo("TESTE");	}
		catch(Exception e)
		{	titulo("Exemplo de Titulo Centralizado");	}
	}
}