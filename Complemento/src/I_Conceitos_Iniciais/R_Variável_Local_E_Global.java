package I_Conceitos_Iniciais;

public class R_Vari�vel_Local_E_Global {

	double x=12.3;		//Vari�vel global -> dentro da classe
	
	public void abc()
	{
		//int a=10;		//Vari�vel local -> dentro do m�todo
		
		//x=20.5;
		double x=25.5;					//N�o � a mesma da vari�vel global
		
		/* for (int a=0; a<10; a++)		//Quando o ciclo for termina, a vari�vel dentro dele morre, podendo criar outra
		   		...
		   int a=20;	ou	a=20;	*/
		
		System.out.print(x);
	}
}