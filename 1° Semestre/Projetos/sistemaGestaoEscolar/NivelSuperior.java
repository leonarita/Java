package sistemaGestaoEscolar;

public interface NivelSuperior {

	double valorHora = 100.50;
	int limiteHora = 30;
	
	int getLimiteHora();
	double getValorHora();
	void setCargaHoraria(int cargaHoraria);
	void setTitulacao(Titulacao titulacao);
	boolean validaLimiteHora(int hora);
}
