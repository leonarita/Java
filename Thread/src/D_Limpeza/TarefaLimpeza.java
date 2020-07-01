package D_Limpeza;

public class TarefaLimpeza implements Runnable {

	private Vaga vaga;

	public TarefaLimpeza(Vaga vaga) {
		this.vaga = vaga;
	}

	@Override
	public void run() {
		
		while(true) {
			this.vaga.limpa();		
			try {
				Thread.sleep(15000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}
	
	
}
