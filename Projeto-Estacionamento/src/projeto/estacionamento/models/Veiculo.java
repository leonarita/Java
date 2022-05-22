package projeto.estacionamento.models;

public abstract class Veiculo {

	//Atributos
	protected String marca;
	protected String modelo;
	protected int anoFabricacao;
	protected int anoModelo;
	protected String chassi;
	protected String placa;

	//Métodos
	// Construtores
	public Veiculo() {
	}
	
	public Veiculo(String marca, String modelo, int anoFabricacao, int anoModelo, String chassi, String placa) {
		
		this.marca = marca;
		this.modelo = modelo;
		this.anoFabricacao = anoFabricacao;
		this.anoModelo = anoModelo;
		this.chassi = chassi;
		this.placa = placa;
	}

	//Getters e Setters

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public int getAnoFabricacao() {
		return anoFabricacao;
	}

	public void setAnoFabricacao(int anoFabricacao) {
		this.anoFabricacao = anoFabricacao;
	}

	public int getAnoModelo() {
		return anoModelo;
	}

	public void setAnoModelo(int anoModelo) {
		this.anoModelo = anoModelo;
	}

	public String getChassi() {
		return chassi;
	}

	public void setChassi(String chassi) {
		this.chassi = chassi;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}	
	
	public abstract String toString();
	
}
