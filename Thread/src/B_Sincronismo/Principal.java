package B_Sincronismo;

public class Principal {
	
	public static void main(String[] args) {
		
		Vaga vaga = new Vaga();
		
		Thread carro1 = new Thread(new CompraRapida(vaga), "Gol");
		Thread carro2 = new Thread(new CompraDemorada(vaga), "Uno");
		
		carro1.start();
		carro2.start();
		
	}

}
