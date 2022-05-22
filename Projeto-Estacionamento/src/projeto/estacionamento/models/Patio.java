package projeto.estacionamento.models;

public class Patio {

	//Atributos
	private String nome, logradouro, numero, bairro, municipio, estado, cep, telefone;
	private int capacidadeVeiculos, lotacao;
	private float diariaCarro, diariaCaminhao;

	//Métodos
	// Construtores	
	public Patio() {
	}
	
	public Patio(String nome, String logradouro, String numero, String bairro, String municipio, String estado, String cep, String telefone, int capacidadeVeiculos, int lotacao, float diariaCarro, float diariaCaminhao) {
		this.nome = nome;
		this.logradouro = logradouro;
		this.numero = numero;
		this.bairro = bairro;
		this.municipio = municipio;
		this.estado = estado;
		this.cep = cep;
		this.telefone = telefone;
		this.capacidadeVeiculos = capacidadeVeiculos;
		this.lotacao = lotacao;
		this.diariaCarro = diariaCarro;
		this.diariaCaminhao = diariaCaminhao;
	}
	
	// Setters e getters

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getMunicipio() {
		return municipio;
	}

	public void setMunicipio(String municipio) {
		this.municipio = municipio;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public int getCapacidadeVeiculos() {
		return capacidadeVeiculos;
	}

	public void setCapacidadeVeiculos(int capacidadeVeiculos) {
		this.capacidadeVeiculos = capacidadeVeiculos;
	}

	public int getLotacao() {
		return lotacao;
	}

	public void setLotacao(int lotacao) {
		this.lotacao = lotacao;
	}

	public float getDiariaCarro() {
		return diariaCarro;
	}

	public void setDiariaCarro(float diariaCarro) {
		this.diariaCarro = diariaCarro;
	}

	public float getDiariaCaminhao() {
		return diariaCaminhao;
	}

	public void setDiariaCaminhao(float diariaCaminhao) {
		this.diariaCaminhao = diariaCaminhao;
	}
	
	public String toString() {
		return "Nome:" + nome + "\tLogradouro: " + logradouro + "\tNúmero: " + numero + "\tBairro: " + bairro + "\tMunicípio: " + municipio +
				"\tEstado: " + estado + "\tcep: " + cep + "\tTelefone: " + telefone + "\tCapacidade de veículos: " + capacidadeVeiculos +
				"\tLotação: " + lotacao + "\tValor da diaria para carros: " + diariaCarro + "\tValor da diaria para caminhões: " + diariaCaminhao;
	}
	
}
