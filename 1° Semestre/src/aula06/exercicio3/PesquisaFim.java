package aula06.exercicio3;

public class PesquisaFim extends Pesquisa {

	@Override
	public final boolean buscarString(String cadeiaCaracteres) {
		return text.endsWith(cadeiaCaracteres);
	}
}
