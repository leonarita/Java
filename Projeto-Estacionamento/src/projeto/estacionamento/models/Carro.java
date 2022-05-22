package projeto.estacionamento.models;

// A classe Carro � "filha" (subclasse / classe filha) da classe Veiculo (o que configura uma Heran�a)
public class Carro extends Veiculo {

	//Atributos
	private int numeroPortas;
	private int qtdPassageiros;

	//M�todos
	//Construtor
	public Carro() {
	}
	
	public Carro(String marca, String modelo, int anoFabricacao, int anoModelo, String chassi, String placa, int numeroPortas, int qtdPassageiros) {
		
		super(marca, modelo, anoFabricacao, anoModelo, chassi, placa);
		this.numeroPortas = numeroPortas;
		this.qtdPassageiros = qtdPassageiros;
	}
	
	// Getters e setters

	public int getNumeroPortas() {
		return numeroPortas;
	}

	public void setNumeroPortas(int numeroPortas) {
		this.numeroPortas = numeroPortas;
	}

	public int getQtdPassageiros() {
		return qtdPassageiros;
	}

	public void setQtdPassageiros(int qtdPassageiros) {
		this.qtdPassageiros = qtdPassageiros;
	}

	@Override
	public String toString() {
		return "Marca: " + marca + "\tModelo: " + modelo + "\tAno de fabrica��o: "+ anoFabricacao + "\tAno de modelo: " + anoModelo + "\tChassi: "
				+ chassi + "\tPlaca: " + placa + "\tQuantidade de passageiros: " + qtdPassageiros + "\tN�mero de portas: "+ numeroPortas;
	}

	
}
