package aula06.exercicio5.versao2;

import java.util.Calendar;

public class Dia implements ITempo {
	
	protected Calendar dataHoraInicial, dataHoraFinal;

	@Override
	public Calendar getDataHoraInicial() {
		return dataHoraInicial;
	}
	
	@Override
	public void setDataHoraInicial(Calendar dataHoraInicial) {
		this.dataHoraInicial = dataHoraInicial;
	}

	@Override
	public Calendar getDataHoraFinal() {
		return dataHoraFinal;
	}

	@Override
	public void setDataHoraFinal(Calendar dataHoraFinal) {
		this.dataHoraFinal = dataHoraFinal;
	}

	@Override
	public float calcularTempo() {
		Long time = dataHoraFinal.getTimeInMillis() - dataHoraInicial.getTimeInMillis();
		return (float) time/(24*60*60*1000);
	}

}
