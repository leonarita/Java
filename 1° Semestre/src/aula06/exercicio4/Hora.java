package aula06.exercicio4;

public class Hora extends Tempo {

	@Override
	protected float calcularTempo() {
		Long time = getDataHoraFinal().getTimeInMillis() - getDataHoraInicial().getTimeInMillis();
		return (float) time/(60*60*1000);
	}

}
