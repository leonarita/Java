package aula06.exercicio3;

public class PesquisaInicio extends Pesquisa {

	@Override
	public final boolean buscarString(String cadeiaCaracteres) {
		return text.startsWith(cadeiaCaracteres);
	}

}
