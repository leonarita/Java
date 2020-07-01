package K_Threads;

public class A_Introducao {
	
	//start(), run(), sleep()

	public static void main(String[] args) {
/*
		BarraDeCarregamento2 barraDeCarregamento2 = new BarraDeCarregamento2();
		BarraDeCarregamento3 barraDeCarregamento3 = new BarraDeCarregamento3();
		
		barraDeCarregamento2.start();
		barraDeCarregamento3.start();
		
		barraDeCarregamento2.run();
		barraDeCarregamento3.run();
		
		Thread t = new Thread(new BarraDeCarregamento2());
		Thread t2 = new Thread(new BarraDeCarregamento3());
		t.start();
		t2.start();
		System.out.println("Nome da thread: " + t.getName());
		System.out.println("Nome da thread: " + t2.getName());
		
		GerarPDF iniciarGeradorPdf = new GerarPDF();
		Thread iniciarBarraDeCarregamento = new Thread();
		iniciarGeradorPdf.start();
		iniciarBarraDeCarregamento.start();
*/	
		GerarPDF iniciarGeradorPdf = new GerarPDF();
		BarraDeCarregamento4 i = new BarraDeCarregamento4(iniciarGeradorPdf);
		i.start();
		iniciarGeradorPdf.start();

	}
}

class GerarPDF extends Thread {

	@Override
	public void run() {
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("Gerando PDF...");
	}
}

class BarraDeCarregamento implements Runnable {

	@Override
	public void run() {
		System.out.println("Loading...");
	}
}

class BarraDeCarregamento2 extends Thread {

	@Override
	public void run() {
		super.run();
		System.out.println("Rodei BarraDeCarregamento2 : " + this.getName());
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}

class BarraDeCarregamento3 extends Thread {

	@Override
	public void run() {
		super.run();
		System.out.println("Rodei BarraDeCarregamento3 : " + this.getName());
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}

class BarraDeCarregamento4 extends Thread {
	
	private Thread iniciarGeradorPDF;

	public BarraDeCarregamento4(Thread iniciarGeradorPDF) {
		this.iniciarGeradorPDF = iniciarGeradorPDF;
	}

	@Override
	public void run() {
		while (true) {
			try {
				Thread.sleep(5000);
				
				if (!iniciarGeradorPDF.isAlive())
					break;
				
				System.out.println("Loading...");
			}
			catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}