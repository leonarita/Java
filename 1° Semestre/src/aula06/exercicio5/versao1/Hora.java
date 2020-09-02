package aula06.exercicio5.versao1;

public class Hora extends Tempo {

	@Override
	public float calcularTempo() {
		Long time = getDataHoraFinal().getTimeInMillis() - getDataHoraInicial().getTimeInMillis();
		return (float) time/(60*60*1000);
	}

}
