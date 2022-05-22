package questao3.models;

import java.util.ArrayList;
import java.util.List;

public class Cliente {
	
	private String numeroTelefone;
	
	private List<ChamadaOriginaria> chamadasOriginarias;
	
	private List<ChamadaRecebida> chamadasRecebidas;
	
	
	// Construtores
	
	public Cliente() {
	}

	public Cliente(String numeroTelefone) {
		this.numeroTelefone = numeroTelefone;
		this.chamadasOriginarias = new ArrayList<ChamadaOriginaria>();
		this.chamadasRecebidas = new ArrayList<ChamadaRecebida>();
	}
	
	public Cliente(String numeroTelefone, List<ChamadaOriginaria> chamadasOriginarias, List<ChamadaRecebida> chamadasRecebidas) {
		super();
		this.numeroTelefone = numeroTelefone;
		this.chamadasOriginarias = chamadasOriginarias;
		this.chamadasRecebidas = chamadasRecebidas;
	}
	
	
	// Setters e Getters

	public String getNumeroTelefone() {
		return numeroTelefone;
	}

	public void setNumeroTelefone(String numeroTelefone) {
		this.numeroTelefone = numeroTelefone;
	}

	public List<ChamadaOriginaria> getChamadasOriginarias() {
		return chamadasOriginarias;
	}

	public void setChamadasOriginarias(List<ChamadaOriginaria> chamadasOriginarias) {
		this.chamadasOriginarias = chamadasOriginarias;
	}

	public List<ChamadaRecebida> getChamadasRecebidas() {
		return chamadasRecebidas;
	}

	public void setChamadasRecebidas(List<ChamadaRecebida> chamadasRecebidas) {
		this.chamadasRecebidas = chamadasRecebidas;
	}
	
	
	// Métodos Adicionais
	
	public void adicionarChamadaRecebida(ChamadaRecebida chamadaRecebida) {
		this.chamadasRecebidas.add(chamadaRecebida);
	}
	
	public void adicionarChamadaOriginaria(ChamadaOriginaria chamadaOriginaria) {
		this.chamadasOriginarias.add(chamadaOriginaria);
	}

}
