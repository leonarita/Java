package IV_Variáveis_De_Instância_E_Classe;

public class Exemplo {

	int x=0;			//x é uma variável de instância -> pertence apenas àquele objeto
	static int y=0;		//y é uma variável de classe  -> pertence àquela classe   ->   usa static
	
	public Exemplo()
	{	++x;
		++y;	}
}