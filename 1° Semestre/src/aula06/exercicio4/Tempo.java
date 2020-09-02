package aula06.exercicio4;

import java.util.Calendar;

public abstract class Tempo {
	
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

	protected abstract float calcularTempo();

	protected boolean validarTempo() {
		
		if (getDataHoraFinal().getTimeInMillis() < getDataHoraInicial().getTimeInMillis())
			return false;
		
		return true;
	}
}
