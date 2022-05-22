package projeto.estacionamento.models;

import projeto.estacionamento.StorageData;

public class Cliente {
	
	//Atributos
	private int codigo;
	private String nome, cpf, logradouro, numero, bairro, municipio, estado, cep, telefone, sexo;

	//Métodos
	// Construtores 
	public Cliente() {
	}
	
	public Cliente(String nome, String cpf, String logradouro, String numero, String bairro, String municipio, String estado, String cep, String telefone, String sexo) {
		this.codigo = StorageData.storage_code_client++;
		this.nome = nome;
		this.cpf = cpf;
		this.logradouro = logradouro;
		this.numero = numero;
		this.bairro = bairro;
		this.municipio = municipio;
		this.estado = estado;
		this.cep = cep;
		this.telefone = telefone;
		this.sexo = sexo;
	}
	
	//Getters e Setters

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
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

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	
	public String toString() {
		return "Nome: " + nome + "\tcpf: " + cpf + "\tLogradouro: " + logradouro + "\tNúmero: " + numero + "\tBairro: " + bairro + "\tMunicípio: "
				+ municipio + "\tEstado: " + estado + "\tcep: " + cep + "\ttelefone: " + telefone + "\tsexo: " + sexo;
	}
	
}
