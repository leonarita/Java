package aula18.exercicio1;

public class Calculator {

	public static void main(String[] args) {

		System.out.println(calculate(15, 10, (n1, n2) -> n1 + n2));
	}

	public static float calculate(float n1, float n2, Operator operator) {
		return operator.calc(n1, n2);
	}
}
