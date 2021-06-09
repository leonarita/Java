package aula06.exercicio2;

public class MathOperations implements Runnable {
	
	private int value1, value2, result;
	
	public MathOperations(int value1, int value2) {
		this.value1 = value1;
		this.value2 = value2;
	}

	@Override
	public void run() {
		int temp = 0, value1Increment = value1;
		
		while(temp < value2) {
			temp += value1Increment;
			value1Increment++;
			result++;
		}
		
		System.out.println();
	}
	
	public int getResult() {
		return this.result;
	}

}
