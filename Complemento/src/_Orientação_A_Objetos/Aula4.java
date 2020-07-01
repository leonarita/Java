package _Orienta��o_A_Objetos;

//Exemplo de m�todo sem retorno de valor.

public class Aula4 
{
	//M�todo titulo, n�o devolve valor e n�o necessita de objetos para ser acionado. Tem uma String que n�o pode ser altera da como par�metro.
	//Passar o texto TESTE para servir como t�tulo do programa - centralizado

	static void titulo (final String texto)
	{	int brancos = (80-texto.length())/2;
		for (int i = 1; i <= brancos; i++)
		System.out.print(' ');
		System.out.println(texto);
	}
	
	//O m�todo main, n�o devolve valor, n�o necessita de objetos para ser acionado e pode ser invocado livremente. Tem uma matriz de String como par�metro

	public static void main (String args[])
	{	try
		{	titulo("TESTE");	}
		catch(Exception e)
		{	titulo("Exemplo de Titulo Centralizado");	}
	}
}