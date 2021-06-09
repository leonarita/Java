package aula05;

public enum CorSemafaro {
	
	VERDE(1000), AMARELO(500), VERMELHO(2000);
	
	private int tempoEspera;
	
	CorSemafaro(int tempoEspera){
		this.tempoEspera = tempoEspera;
	}

	public int getTempoEspera() {
		return tempoEspera;
	}
}