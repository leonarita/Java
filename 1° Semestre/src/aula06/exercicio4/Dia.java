package aula06.exercicio4;

public class Dia extends Tempo {

	@Override
	protected float calcularTempo() {
		Long time = dataHoraFinal.getTimeInMillis() - dataHoraInicial.getTimeInMillis();
		return (float) time/(24*60*60*1000);
	}

}
