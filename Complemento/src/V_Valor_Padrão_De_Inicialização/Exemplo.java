package V_Valor_Padrão_De_Inicialização;

public class Exemplo {

//Variáveis globais recebem o valor padrão de inicialização	
	
	//Valores inteiros são inicializados com 0
	byte a;
	short b;
	int c;
	long d;
	
	//Valores decimais são inicializados com 0.0
	float e;
	double f;
	
	//O caractere é inicializado com o caractere blank - \u0000
	char g;
	
	//Boolean é inicializado com false
	boolean h;
	
	//Objetos acessados por referência são inicializados com null
	String i;
	
	public void abc()
	{	int x = 20;
		System.out.println (x);	}
//Variáveis locais não recebem o valor padrão de inicialização	
	
}