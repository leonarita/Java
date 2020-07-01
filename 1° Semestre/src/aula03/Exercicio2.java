package aula03;

public class Exercicio2 
{
	public static void main(String[] args) 
	{
		String texto = "Uma ideia traz outra; o boticário imaginou que, uma vez preso o alienista, viriam também buscá-lo " + 
				"a ele, na qualidade de cúmplice. Esta ideia foi o melhor dos vesicatórios. Crispim Soares ergueu-se, " + 
				"disse que estava bom, que ia sair; e apesar de todos os esforços e protestos da consorte vestiu-se e " + 
				"saiu. Os velhos cronistas são unânimes em dizer que a certeza de que o marido ia colocar-se " + 
				"nobremente ao lado do alienista consolou grandemente a esposa do boticário; e notam com muita " + 
				"perspicácia, o imenso poder moral de uma ilusão; porquanto, o boticário caminhou resolutamente " + 
				"ao palácio do governo, não à casa do alienista. Ali chegando, mostrou-se admirado de não ver o " + 
				"barbeiro, a quem ia apresentar os seus protestos de adesão, não o tendo feito desde a véspera por " + 
				"enfermo. E tossia com algum custo. Os altos funcionários que lhe ouviam esta declaração, " + 
				"sabedores da intimidade do boticário com o alienista, compreenderam toda a importância da " + 
				"adesão nova e trataram a Crispim Soares com apurado carinho; afirmaram-lhe que o barbeiro não " + 
				"tardava; Sua Senhoria tinha ido à Casa Verde, a negócio importante, mas não tardava. Deram-lhe " + 
				"cadeira, refrescos, elogios; disseram-lhe que a causa do ilustre Porfírio era a de todos os patriotas; " + 
				"ao que o boticário ia repetindo que sim, que nunca pensara outra coisa, que isso mesmo mandaria " + 
				"declarar a Sua Majestade.";
		
		//Recupere/extraia do texto a frase “E tossia com algum custo” e retorne-a ao usuário.
		System.out.println(texto.substring(texto.indexOf("E tossia com algum custo"), texto.indexOf("E tossia com algum custo") + "E tossia com algum custo".length()));
		
		//Substitua as ocorrências de “alienista” por “psiquiatra”.
		texto = texto.replace("alienista", "psiquiatra");
		
		//Altere as ocorrências de “Crispim Soares” para letras maiúsculas.
		String subs = "Crispim Soares";
		texto = texto.replace(subs, subs.toLowerCase());
		
		//Retorne se o texto contém as palavras “vila”, “custo” e “receio”.
		String[] words = { "vila", "custo", "receio "};
		for (String i : words)
			System.out.println(texto.contains(i));
		
		//Retorne quantas vezes a palavra “não” aparece no texto.
		System.out.println("A palavra 'não' apareceu " + (texto.split("não").length-1) + " vezes.");
		
		//Retorne quantos caracteres o texto possui.
		int numCarac = texto.length();
		System.out.println("O texto possui "+ numCarac + " caracteres.");
		
		//Retorne quantos espaços o texto possui.
		int numVazios = texto.replace(" ", "").length();
		System.out.println("O texto possui "+ (numCarac - numVazios) + " espaços.");
//Modo 2:	System.out.println("O texto possui "+ (texto.split(" ").length-1) + " espaços.");
	}
}