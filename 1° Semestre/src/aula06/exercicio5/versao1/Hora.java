package aula06.exercicio5.versao1;

public class Hora extends Tempo {

	@Override
	public float calcularTempo() {
		Long time = dataHoraFinal.getTimeInMillis() - dataHoraInicial.getTimeInMillis();
		return (float) time/(60*60*1000);
	}

}
