package _Orientação_A_Objetos;

class Gestante
{	String nome;
	float peso;
	float altura;
	
	float imc()
	{	float IMC = peso / (altura*altura);
		return ( IMC );
	}
	
	int categoria (float ganho, int semana)
	{	int cat=0;
		//float Novoimc = (peso + ganho) / (altura*altura);
		return ( cat );
	}
	
	void mostraAtributos()
	{	System.out.print("Nome da paciente: " + nome );
		System.out.print(" - Peso: " + peso + " Kgs");
		System.out.println(" - Altura " + altura);
		System.out.println("IMC pré-gestacional: " + imc() );
	}
	
	Gestante(String n, char s, float p, float a)
	{	nome = n;
		peso = p;
		altura = a;
	}
	
	Gestante()
	{	nome = "Ana Maria";
		peso = 56.6f;
		altura = 1.7f;
	}
}

class Aula2
{	public static void main (String args[])
	{	Gestante g = new Gestante();
		g.mostraAtributos();
	}
}