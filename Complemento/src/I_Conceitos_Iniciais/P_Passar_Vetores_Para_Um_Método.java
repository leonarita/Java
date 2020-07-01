package I_Conceitos_Iniciais;

public class P_Passar_Vetores_Para_Um_Método 
{	public static void main (String[] args)
	{
		int[] abc= {1,2,3,4,5};
		int xyz=10;
		
		vetor(abc);
		variavelPrimitiva(xyz);
		
		System.out.println (abc[0]);		//Por ser vetor, o método o altera								//200
		System.out.println (xyz);			//Por ser variável primitiva, o método não o altera				//10
	}

	public static void vetor (int[] x)
	{	System.out.println (x[0]);			//1
		x[0]=200;
		System.out.println (x[0]);	}		//200
	
	public static void variavelPrimitiva (int x)
	{	System.out.println (x);				//10
		x=200;
		System.out.println (x);		}		//200

}