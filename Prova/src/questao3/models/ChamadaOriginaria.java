package questao3.models;

public class ChamadaOriginaria extends ChamadaTelefonica {
	
	private String telefoneDestino;
	
	
	// Construtores

	public ChamadaOriginaria() {
	}
	
	public ChamadaOriginaria(String telefoneDestino) {
		this.telefoneDestino = telefoneDestino;
	}

	public ChamadaOriginaria(String dataChamada, String horaChamada, String duracao) {
		super(dataChamada, horaChamada, duracao);
	}
	
	public ChamadaOriginaria(String dataChamada, String horaChamada, String duracao, String telefoneDestino) {
		super(dataChamada, horaChamada, duracao);
		this.telefoneDestino = telefoneDestino;
	}
	
	
	// Setters e Getters

	public String getTelefoneDestino() {
		return telefoneDestino;
	}

	public void setTelefoneDestino(String telefoneDestino) {
		this.telefoneDestino = telefoneDestino;
	}

}
