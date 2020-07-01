package aula03;

public class Exercicio2 
{
	public static void main(String[] args) 
	{
		String texto = "Uma ideia traz outra; o botic�rio imaginou que, uma vez preso o alienista, viriam tamb�m busc�-lo " + 
				"a ele, na qualidade de c�mplice. Esta ideia foi o melhor dos vesicat�rios. Crispim Soares ergueu-se, " + 
				"disse que estava bom, que ia sair; e apesar de todos os esfor�os e protestos da consorte vestiu-se e " + 
				"saiu. Os velhos cronistas s�o un�nimes em dizer que a certeza de que o marido ia colocar-se " + 
				"nobremente ao lado do alienista consolou grandemente a esposa do botic�rio; e notam com muita " + 
				"perspic�cia, o imenso poder moral de uma ilus�o; porquanto, o botic�rio caminhou resolutamente " + 
				"ao pal�cio do governo, n�o � casa do alienista. Ali chegando, mostrou-se admirado de n�o ver o " + 
				"barbeiro, a quem ia apresentar os seus protestos de ades�o, n�o o tendo feito desde a v�spera por " + 
				"enfermo. E tossia com algum custo. Os altos funcion�rios que lhe ouviam esta declara��o, " + 
				"sabedores da intimidade do botic�rio com o alienista, compreenderam toda a import�ncia da " + 
				"ades�o nova e trataram a Crispim Soares com apurado carinho; afirmaram-lhe que o barbeiro n�o " + 
				"tardava; Sua Senhoria tinha ido � Casa Verde, a neg�cio importante, mas n�o tardava. Deram-lhe " + 
				"cadeira, refrescos, elogios; disseram-lhe que a causa do ilustre Porf�rio era a de todos os patriotas; " + 
				"ao que o botic�rio ia repetindo que sim, que nunca pensara outra coisa, que isso mesmo mandaria " + 
				"declarar a Sua Majestade.";
		
		//Recupere/extraia do texto a frase �E tossia com algum custo� e retorne-a ao usu�rio.
		System.out.println(texto.substring(texto.indexOf("E tossia com algum custo"), texto.indexOf("E tossia com algum custo") + "E tossia com algum custo".length()));
		
		//Substitua as ocorr�ncias de �alienista� por �psiquiatra�.
		texto = texto.replace("alienista", "psiquiatra");
		
		//Altere as ocorr�ncias de �Crispim Soares� para letras mai�sculas.
		String subs = "Crispim Soares";
		texto = texto.replace(subs, subs.toLowerCase());
		
		//Retorne se o texto cont�m as palavras �vila�, �custo� e �receio�.
		String[] words = { "vila", "custo", "receio "};
		for (String i : words)
			System.out.println(texto.contains(i));
		
		//Retorne quantas vezes a palavra �n�o� aparece no texto.
		System.out.println("A palavra 'n�o' apareceu " + (texto.split("n�o").length-1) + " vezes.");
		
		//Retorne quantos caracteres o texto possui.
		int numCarac = texto.length();
		System.out.println("O texto possui "+ numCarac + " caracteres.");
		
		//Retorne quantos espa�os o texto possui.
		int numVazios = texto.replace(" ", "").length();
		System.out.println("O texto possui "+ (numCarac - numVazios) + " espa�os.");
//Modo 2:	System.out.println("O texto possui "+ (texto.split(" ").length-1) + " espa�os.");
	}
}