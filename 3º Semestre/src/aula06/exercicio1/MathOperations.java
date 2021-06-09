package aula06.exercicio1;

public class MathOperations implements Runnable {
	
	private float value1, value2, soma;
	
	public MathOperations(float value1, float value2) {
		this.value1 = value1;
		this.value2 = value2;
	}

	@Override
	public void run() {
		this.soma = this.value1 + this.value2;
	}
	
	public float getSoma() {
		return this.soma;
	}

}
