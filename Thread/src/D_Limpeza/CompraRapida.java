package D_Limpeza;

public class CompraRapida implements Runnable{

	private Vaga vaga;
	
	public CompraRapida(Vaga vaga) {
		this.vaga = vaga;
	}
	
	@Override
	public void run() {
		this.vaga.compraRapida();
	}

}
