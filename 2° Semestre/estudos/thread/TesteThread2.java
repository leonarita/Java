package thread;

public class TesteThread2 {
		
	public static void main (String... args) {
		
		Compra c1 = new Compra(200);
		
		new Thread(() -> {
			aplicarDesconto(c1, 20);
		}).start();		
		
		new Thread(() -> {
			aplicarDesconto(c1, 20);
		}).start();	
		
		new Thread(() -> {
			aplicarDesconto(new Compra(100), 20);
		}).start();	
	}
	
	// Se duas threads acessar ao mesmo tempo, haverá aplicação de dois descontos. Impedimos isso com syncronized
	// Ao uma thread executar, outra vai esperar terminar para poder executar o método
	public synchronized static void aplicarDesconto(Compra compra, double porcentagem) {
		
		if (compra.jaTeveDesconto) {
			System.out.println("Valor: R$ " + compra.getValue());
			return;
		}
		
		compra.setJaTeveDesconto(true);
		compra.setValue(compra.getValue() - (compra.getValue() * (porcentagem/100)));
		System.out.println("Valor: R$ " + compra.getValue());
	}
	
	public static class Compra {
		private double value;
		private boolean jaTeveDesconto = false;
		
		Compra(double value) {
			this.value = value;
		}
		
		public double getValue() {
			return value;
		}
		
		public void setValue(double value) {
			this.value = value;
		}
		
		public boolean isJaTeveDesconto() {
			return jaTeveDesconto;
		}
		
		public void setJaTeveDesconto(boolean jaTeveDesconto) {
			this.jaTeveDesconto = jaTeveDesconto;
		}
	}

}
