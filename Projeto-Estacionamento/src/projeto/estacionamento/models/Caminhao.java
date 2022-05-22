package projeto.estacionamento.models;

//A classe Caminhao � "filha" (subclasse / classe filha) da classe Veiculo (o que configura uma Heran�a)
public class Caminhao extends Veiculo {

	//Atributos
	private int nmrEixos;
	private float capacidadeCarga;
	
	//M�todos
	//Construtor
	public Caminhao() {
	}
	
	public Caminhao(int nmrEixos, float capacidadeCarga, String marca, String modelo, int anoFabricacao, int anoModelo, String chassi, String placa) {	
		super(marca, modelo, anoFabricacao, anoModelo, chassi, placa);
		this.nmrEixos = nmrEixos;
		this.capacidadeCarga = capacidadeCarga;
	}
	
	//Getters e setters

	public int getNmrEixos() {
		return nmrEixos;
	}

	public void setNmrEixos(int nmrEixos) {
		this.nmrEixos = nmrEixos;
	}

	public float getCapacidadeCarga() {
		return capacidadeCarga;
	}

	public void setCapacidadeCarga(float capacidadeCarga) {
		this.capacidadeCarga = capacidadeCarga;
	}	
	
	@Override
	public String toString() {
		return "Marca: " + marca + "\tModelo: " + modelo + "\tAno de fabrica��o: "+ anoFabricacao + "\tAno de modelo: " + anoModelo + "\tChassi: "
				+ chassi + "\tPlaca: " + placa + "\tN�mero de eixos: " + nmrEixos + "\tCapacidade de carga: "+ capacidadeCarga;
	}

}
