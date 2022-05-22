package projeto.estacionamento.models;

import java.time.LocalDate;

public class Conta {
	
	//Atributos
	private Cliente cliente;
	private Veiculo veiculo;
	private Patio patio;
	private int ano;
	private int mes;
	private int diarias;
	private boolean statusConta;

	//Métodos
	// Construtores	
	public Conta() {
	}
	
	public Conta(Cliente cliente, Veiculo veiculo, Patio patio) {
		LocalDate date = LocalDate.now();

		this.cliente = cliente;
		this.veiculo = veiculo;
		this.patio = patio;
		this.ano = date.getYear();
		this.mes = date.getMonth().getValue();
		this.diarias = 1;
		this.statusConta = false;
	}

	public Conta(Cliente cliente, Veiculo veiculo, Patio patio, int ano, int mes, int diarias, boolean statusConta) {
		super();
		this.cliente = cliente;
		this.veiculo = veiculo;
		this.patio = patio;
		this.ano = ano;
		this.mes = mes;
		this.diarias = diarias;
		this.statusConta = statusConta;
	}
	
	// Getters e setters

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Veiculo getVeiculo() {
		return veiculo;
	}

	public void setVeiculo(Veiculo veiculo) {
		this.veiculo = veiculo;
	}

	public Patio getPatio() {
		return patio;
	}

	public void setPatio(Patio patio) {
		this.patio = patio;
	}

	public int getAno() {
		return ano;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}

	public int getMes() {
		return mes;
	}

	public void setMes(int mes) {
		this.mes = mes;
	}

	public int getDiarias() {
		return diarias;
	}

	public void setDiarias(int diarias) {
		this.diarias = diarias;
	}

	public boolean isStatusConta() {
		return statusConta;
	}

	public void setStatusConta(boolean statusConta) {
		this.statusConta = statusConta;
	}
	
	// Métodos adicionais
	
	public int adicionarDiaria() {
		return diarias++;
	}
	
	public int excluirDiaria() {
		return diarias--;
	}
	
	public float calcularTotalAPagar() {
		if(veiculo instanceof Carro)
			return patio.getDiariaCarro() * diarias;
		else
			return patio.getDiariaCaminhao() * diarias;
	}
	
}
