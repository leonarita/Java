package questao3.models;

public class ChamadaRecebida extends ChamadaTelefonica {
	
	private String telefoneOrigem;
	
	private String valorChamada;
	
	
	// Construtores
	
	public ChamadaRecebida() {
	}

	public ChamadaRecebida(String dataChamada, String horaChamada, String duracao) {
		super(dataChamada, horaChamada, duracao);
	}

	public ChamadaRecebida(String telefoneOrigem, String valorChamada) {
		super();
		this.telefoneOrigem = telefoneOrigem;
		this.valorChamada = valorChamada;
	}
	
	public ChamadaRecebida(String dataChamada, String horaChamada, String duracao, String telefoneOrigem, String valorChamada) {
		super(dataChamada, horaChamada, duracao);
		this.telefoneOrigem = telefoneOrigem;
		this.valorChamada = valorChamada;
	}
	
	
	// Setters e Getters

	public String getTelefoneOrigem() {
		return telefoneOrigem;
	}

	public void setTelefoneOrigem(String telefoneOrigem) {
		this.telefoneOrigem = telefoneOrigem;
	}

	public String getValorChamada() {
		return valorChamada;
	}

	public void setValorChamada(String valorChamada) {
		this.valorChamada = valorChamada;
	}

}
