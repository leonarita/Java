package I_Conceitos_Iniciais;

//Break 	-> Quebra ciclos (usado no while, switch)
//Continue	-> Pula o restante das instruções, mas continua usando o ciclo

import java.util.Scanner;

public class H_Break_E_Continue {
	public static void main (String[] args)
	{	Scanner input = new Scanner (System.in);
	
		System.out.println ("Digite um número de 0 a 10: ");
		int numero = input.nextInt();
		
		for (int i=0; i<=10; ++i)
		{	if (i==numero)
			{	System.out.println ("O seu número é " +i);
				/*break;*/		}
			else
			{	System.out.println ("O seu número não é " +i);
				continue;	}
		
		System.out.println("XXXXXXXXX");
		}
		
		input.close();
	}
}