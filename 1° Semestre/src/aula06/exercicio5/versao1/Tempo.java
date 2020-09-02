package aula06.exercicio5.versao1;

import java.util.Calendar;

public abstract class Tempo implements ITempo {
	
	private Calendar dataHoraInicial, dataHoraFinal;

	protected Calendar getDataHoraInicial() {
		return dataHoraInicial;
	}
	
	protected void setDataHoraInicial(Calendar dataHoraInicial) {
		this.dataHoraInicial = dataHoraInicial;
	}

	protected Calendar getDataHoraFinal() {
		return dataHoraFinal;
	}

	protected void setDataHoraFinal(Calendar dataHoraFinal) {
		this.dataHoraFinal = dataHoraFinal;
	}
}
