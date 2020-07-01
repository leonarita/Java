package I_Conceitos_Iniciais;

import java.util.Scanner;

public class O_Passar_Variáveis_Primitiva_Para_Métodos
{	
	public static void main(String[] args)
	{	Scanner input = new Scanner(System.in);
		 
		System.out.println("Informe o valor da base: ");
		double base = input.nextDouble();
		 
		System.out.println("Informe o valor da altura: ");
		double altura = input.nextDouble();
		 
		double areaRetangulo = retangulo(base, altura);
		
		//double areaRetangulo = retangulo(10.50, 30.5);		//Argumento -> valor passado para o método
		 
		System.out.println(areaRetangulo);
		
		input.close();
	}
		 
	public static double retangulo(double base, double altura)	//Parâmetro -> dentro do parênteses do método
	{	return base * altura;	}
	
}