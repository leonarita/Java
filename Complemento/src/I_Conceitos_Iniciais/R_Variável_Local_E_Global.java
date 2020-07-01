package I_Conceitos_Iniciais;

public class R_Variável_Local_E_Global {

	double x=12.3;		//Variável global -> dentro da classe
	
	public void abc()
	{
		//int a=10;		//Variável local -> dentro do método
		
		//x=20.5;
		double x=25.5;					//Não é a mesma da variável global
		
		/* for (int a=0; a<10; a++)		//Quando o ciclo for termina, a variável dentro dele morre, podendo criar outra
		   		...
		   int a=20;	ou	a=20;	*/
		
		System.out.print(x);
	}
}