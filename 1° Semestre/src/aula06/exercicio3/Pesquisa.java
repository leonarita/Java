package aula06.exercicio3;

public class Pesquisa {

	private static String text;

	protected String getText() {
		return text;
	}

	protected static void setText(String text) {
		Pesquisa.text = text;
	}
	
	protected boolean buscarString(String cadeiaCaracteres) {
		return text.contains(cadeiaCaracteres);
	}
}
