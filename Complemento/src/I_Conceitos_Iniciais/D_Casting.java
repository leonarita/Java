package I_Conceitos_Iniciais;

import java.util.Scanner;

public class D_Casting {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
	 
		 int x = 10;
		 int y = 6; int z = 3;
		 double a = 3, b = 1.0;
		 double c = (double) x / y;
		 int h = (int) c;
		 
		 System.out.println("x = " + x);
		 System.out.println("y = " + y);
		 System.out.println("z = " + z);
		 System.out.println("a = " + a);
		 System.out.println("b = " + b);
		 System.out.println("c = " + c);
		 System.out.println("h = " + h);
		 
		 
		 final double PI = 3.14159;
		 //Variáveis "final" não podem ser alteradas ao decorrer do programa
		 
		 System.out.println("\n\nInforme o valor do raio");
		 double raio = input.nextDouble();
		 double area = raio * raio * PI;	 
		 System.out.println("O valor da area é = " + area);
	 
		 input.close();
	 }
}
