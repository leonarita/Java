package _Orienta��o_A_Objetos;

class Conta
{

//Estado - conjunto de propriedades (ATRIBUTOS) : Aqui s� declaramos as propriedades que descrevem o que o objeto �.
//A instancia��o dos objetos (atribui��o dos valores) ser� feita de modo direto ou atrav�s da chamada de m�todos construtores,
//sempre no programa principal, onde a cria��o do objeto ocorre.

	int numero;
	String dono;
	double saldo;
	double limite;

//Comportamento (M�TODOS) - a��es que podem ser atribu�das aos objetos desta classe.

//O m�todo imprimeBanco identifica de qual banco � a conta.
	
	void imprimeBanco()
	{	System.out.println("Esta conta � do Banco J.");	}
	
// O m�todo saca atualiza o valor do saldo subtraindo-se a quantidade do saldo

	void saca(double quantidade)
	{	double novoSaldo = this.saldo - quantidade;	
	
	//Dentro deste m�todo, estamos declarando uma nova vari�vel.
	//Essa vari�vel, assim como o argumento, vai "morrer" no fim do m�todo,pois este � seu escopo.
	//No momento que vamos acessar nosso atributo, usamos a palavra chave this para	mostrar que esse � um atributo, e n�o uma simples vari�vel.
		
		this.saldo = novoSaldo;
	}
	
	// O m�todo deposita servir� para depositar alguma quantia.
	
	void deposita(double quantidade)
	{	this.saldo += quantidade;	}
	
//Um m�todo que mostra os atributos dos objetos pertencentes � classe � sempre �til para n�o reproduzir os c�digos no programa principal.

	void mostraAtributos()
	{	System.out.println("======================================");
		System.out.println("Numero da conta : " + this.numero );
		System.out.println("Nome do titular da conta: " + this.dono );
		System.out.println("Saldo na conta : R$ " + this.saldo );
		System.out.println("Limite na conta : R$ " + this.limite );
		System.out.println("======================================");
	}
	
// M�todos Construtores s�o os m�todos utilizados para determinar os valores com os quais o objeto ser� criado na mem�ria. 
//Se n�o houver nenhum m�todo construtor, o objeto ser� criado com valores nulos.
//O m�todo construtor deve ter exatamente o mesmo nome da classe

	Conta()
	{	this.numero = 0;
		this.dono = "";
		this.saldo = 0.0;
		this.limite = 0.0;
	}
	
//O m�todo construtor pode possuir argumentos para passagem par�metros. Observe que o nome do m�todo construtor � sempre o mesmo. 
//O programa saber� qual m�todo construtor chamar, gra�as aos diferentes par�metros (quantidades e tipos)
// Esta capacidade � referenciada como SOBRECARGA dos nomes dos m�todos. Isto � poss�vel gra�as ao POLIMORFISMO!

	Conta(int n, String d, double sal, double lim)
	{	this.numero = n;
		this.dono = d;
		this.saldo = sal;
		this.limite = lim;
	}
}

public class Aula3
{	public static void main(String[] args)
	{	// criando a conta
		Conta minhaConta;
		minhaConta = new Conta();

		// Mostra os atributos de minhaConta
		minhaConta.mostraAtributos();

		// alterando os valores de minhaConta
		minhaConta.numero = 1001;
		minhaConta.dono = "Maria do Carmo";
		minhaConta.saldo = 1000;
		minhaConta.limite = 3000;

		// Mostra os atributos de minhaConta
		minhaConta.mostraAtributos();

		// saca 200 reais
		minhaConta.saca(200);

		// Mostra os atributos de minhaConta
		minhaConta.mostraAtributos();

		// deposita 500 reais
		minhaConta.deposita(500);

		// Mostra os atributos de minhaConta
		minhaConta.mostraAtributos();
	}
}
