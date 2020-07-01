package _Orientação_A_Objetos;

class Conta
{

//Estado - conjunto de propriedades (ATRIBUTOS) : Aqui só declaramos as propriedades que descrevem o que o objeto é.
//A instanciação dos objetos (atribuição dos valores) será feita de modo direto ou através da chamada de métodos construtores,
//sempre no programa principal, onde a criação do objeto ocorre.

	int numero;
	String dono;
	double saldo;
	double limite;

//Comportamento (MÉTODOS) - ações que podem ser atribuídas aos objetos desta classe.

//O método imprimeBanco identifica de qual banco é a conta.
	
	void imprimeBanco()
	{	System.out.println("Esta conta é do Banco J.");	}
	
// O método saca atualiza o valor do saldo subtraindo-se a quantidade do saldo

	void saca(double quantidade)
	{	double novoSaldo = this.saldo - quantidade;	
	
	//Dentro deste método, estamos declarando uma nova variável.
	//Essa variável, assim como o argumento, vai "morrer" no fim do método,pois este é seu escopo.
	//No momento que vamos acessar nosso atributo, usamos a palavra chave this para	mostrar que esse é um atributo, e não uma simples variável.
		
		this.saldo = novoSaldo;
	}
	
	// O método deposita servirá para depositar alguma quantia.
	
	void deposita(double quantidade)
	{	this.saldo += quantidade;	}
	
//Um método que mostra os atributos dos objetos pertencentes à classe é sempre útil para não reproduzir os códigos no programa principal.

	void mostraAtributos()
	{	System.out.println("======================================");
		System.out.println("Numero da conta : " + this.numero );
		System.out.println("Nome do titular da conta: " + this.dono );
		System.out.println("Saldo na conta : R$ " + this.saldo );
		System.out.println("Limite na conta : R$ " + this.limite );
		System.out.println("======================================");
	}
	
// Métodos Construtores são os métodos utilizados para determinar os valores com os quais o objeto será criado na memória. 
//Se não houver nenhum método construtor, o objeto será criado com valores nulos.
//O método construtor deve ter exatamente o mesmo nome da classe

	Conta()
	{	this.numero = 0;
		this.dono = "";
		this.saldo = 0.0;
		this.limite = 0.0;
	}
	
//O método construtor pode possuir argumentos para passagem parâmetros. Observe que o nome do método construtor é sempre o mesmo. 
//O programa saberá qual método construtor chamar, graças aos diferentes parâmetros (quantidades e tipos)
// Esta capacidade é referenciada como SOBRECARGA dos nomes dos métodos. Isto é possível graças ao POLIMORFISMO!

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
