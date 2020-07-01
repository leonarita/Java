package B_Classe;

public class Inicio {

	public static void main(String[] args) {

		criandoObjetos();
		System.out.println("\n-----------------------------------------\n");
		
		destruindoObjetos();
		System.out.println("\n-----------------------------------------\n");

		exemploEstatico();
		System.out.println("\n-----------------------------------------\n");
	}

	public static void criandoObjetos() {
		
		Veiculo carro1 = new Veiculo();
		carro1.numeroDeSerie = 1010;
		System.out.println("S�rie: " + carro1.numeroDeSerie);
		
		Veiculo carro2 = new Veiculo();

		for (int i=0; i<10; i++) {
			carro2.acelerar(10.0f);
			System.out.println("Carro C2: " + carro2.velocidadeAtual);
		}
		
		System.out.println("Carro C1: " + carro1.velocidadeAtual);
	}
	
	public static void destruindoObjetos() {

		Veiculo carro1 = new Veiculo();
		carro1.numeroDeSerie = 1;
		
		Veiculo carro2 = new Veiculo();
		carro2.numeroDeSerie = 2;
		
		System.out.println("Serial Carro1: " + carro1.numeroDeSerie);
		System.out.println("Serial Carro2: " + carro2.numeroDeSerie);
		
		carro1 = carro2;
		
		System.out.println("A inst�ncia originalmente indicada por carro1 pode ser destruida, pois n�o h� refer�ncias.");
		
		carro2.numeroDeSerie = 20;
		System.out.println("Serial Carro1: " + carro1.numeroDeSerie);
		System.out.println("Serial Carro2: " + carro2.numeroDeSerie);
		
		carro2 = null;
		System.out.println("Serial Carro1: " + carro1.numeroDeSerie);

		if (carro2==null)
			System.out.println("Refer�ncia de carro2 � nula");
		
		carro1 = null;
		System.out.println("A inst�ncia originalmente indicada por carro2 pode ser destruida, pois n�o h� refer�ncias.");
	}

	public static void exemploEstatico() {

		System.out.println("Classe: " + Veiculo.metodoEstatico());
		
		Veiculo carro = new Veiculo();
		
		System.out.println("Inst�ncia: " + carro.metodoEstatico());
		
		Veiculo.atributoEstatico = 5;
		System.out.println("Inst�ncia: " + carro.metodoEstatico());
		
		
		Veiculo novoCarro = new Veiculo();
		System.out.println("Inst�ncia: " + novoCarro.metodoEstatico());
	}
}
