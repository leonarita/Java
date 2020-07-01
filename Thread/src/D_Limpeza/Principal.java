package D_Limpeza;

public class Principal {
	
	public static void main(String[] args) {
		
		Vaga vaga = new Vaga();
		
		Thread carro1 = new Thread(new CompraRapida(vaga), "Gol");
		Thread carro2 = new Thread(new CompraDemorada(vaga), "Uno");
		Thread limpeza = new Thread(new TarefaLimpeza(vaga), "limpeza");
		//N�o faz sentido a limpeza continuar verificando a vaga
		//quando n�o h� mais nenhuma Thread com necessidade.
		//por isso setamos setDaemon(true)
		limpeza.setDaemon(true);

		carro1.start();
		carro2.start();
		limpeza.start();
	}

}
