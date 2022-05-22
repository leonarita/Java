package questao3.models;

public class ChamadaTelefonica {
	
	private String dataChamada;
	
	private String horaChamada;
	
	private String duracao;
	
	
	// Construtores

	public ChamadaTelefonica() {
	}
	
	public ChamadaTelefonica(String dataChamada, String horaChamada, String duracao) {
		this.dataChamada = dataChamada;
		this.horaChamada = horaChamada;
		this.duracao = duracao;
	}
	
	
	// Setters e Getters

	public String getDataChamada() {
		return dataChamada;
	}

	public void setDataChamada(String dataChamada) {
		this.dataChamada = dataChamada;
	}

	public String getHoraChamada() {
		return horaChamada;
	}

	public void setHoraChamada(String horaChamada) {
		this.horaChamada = horaChamada;
	}

	public String getDuracao() {
		return duracao;
	}

	public void setDuracao(String duracao) {
		this.duracao = duracao;
	}

}
