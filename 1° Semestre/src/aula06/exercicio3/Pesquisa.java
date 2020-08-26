package aula06.exercicio3;

public class Pesquisa {

	protected static String text;

	public String getText() {
		return text;
	}

	public static void setText(String text) {
		Pesquisa.text = text;
	}
	
	public boolean buscarString(String cadeiaCaracteres) {
		return text.contains(cadeiaCaracteres);
	}
}
