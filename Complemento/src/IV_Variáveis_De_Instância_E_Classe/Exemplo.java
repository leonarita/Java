package IV_Vari�veis_De_Inst�ncia_E_Classe;

public class Exemplo {

	int x=0;			//x � uma vari�vel de inst�ncia -> pertence apenas �quele objeto
	static int y=0;		//y � uma vari�vel de classe  -> pertence �quela classe   ->   usa static
	
	public Exemplo()
	{	++x;
		++y;	}
}