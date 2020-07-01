package D_Limpeza;

public class Vaga {

	
	private boolean ehsuja  = true;
	
	
	public void compraRapida() {
		
		String nome = Thread.currentThread().getName();
		
		System.out.println(nome + " procurando vaga no estacionamento");
		
		synchronized (this) {
			System.out.println(nome + " Entrou na vaga!");
			while (this.ehsuja) {
				espera(nome);
			}
			System.out.println(nome + " fazendo compra rápida!");
			try {
				Thread.sleep(8000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(nome +  " colocando as compras no carro");
			this.ehsuja = true;
			System.out.println(nome +  " entrando no carro");
			System.out.println(nome +  " saindo da vaga");

		}

	}
	
	
	private void espera(String nome) {
		System.out.println(nome + ", eca, vaga esta suja");
		try {
			this.wait();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}


	public void compraDemorada() {
		
		String nome = Thread.currentThread().getName();
		
		System.out.println(nome + " procurando vaga no estacionamento");
		synchronized (this) {
			System.out.println(nome + " Entrou na vaga!");
			while (this.ehsuja) {
				espera(nome);
			}
			System.out.println(nome + " fazendo compra demorada!");
			try {
				Thread.sleep(15000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(nome +  " colocando as compras no carro");
			this.ehsuja = true;
			System.out.println(nome +  " entrando no carro");
			System.out.println(nome +  " saindo da vaga");
		}
		
	}

	
	public void limpa() {
		String nome = Thread.currentThread().getName();
		System.out.println(nome + " procurando vaga para limpar");
		
		synchronized (this) {
			System.out.println(nome + " Entrou na vaga!");
			
			if (!ehsuja) {
				System.out.println(nome+" não esta suja, vou sair");
				return;
			}
			
			System.out.println(nome + " limpando a vaga!");
			this.ehsuja = false;
			try {
				Thread.sleep(13000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			this.notifyAll();
			System.out.println(nome +  " saindo da vaga");
		}
		
	}
	
}
