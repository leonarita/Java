package aula06.exercicio5.versao1;

import java.util.Calendar;

public abstract class Tempo implements ITempo {
	
	protected Calendar dataHoraInicial, dataHoraFinal;

	public Calendar getDataHoraInicial() {
		return dataHoraInicial;
	}
	
	public void setDataHoraInicial(Calendar dataHoraInicial) {
		this.dataHoraInicial = dataHoraInicial;
	}

	public Calendar getDataHoraFinal() {
		return dataHoraFinal;
	}

	public void setDataHoraFinal(Calendar dataHoraFinal) {
		this.dataHoraFinal = dataHoraFinal;
	}
}
