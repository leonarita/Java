package aula06.exercicio5.versao2;

import java.util.Calendar;

public interface ITempo {

	float calcularTempo();
	
	Calendar getDataHoraInicial();
	
	void setDataHoraInicial(Calendar dataHoraInicial);

	Calendar getDataHoraFinal();

	void setDataHoraFinal(Calendar dataHoraFinal);
}
