package I_Conceitos_Iniciais;

public class Q_Retornar_Vetores_De_Um_Método
{
	public static void main (String[] args)
	{
		double[] aaa = {10.2, 34.2,  45.6, 43, 56};
		double[] ccc = inverterVetor(aaa);
		
		for (int i=0; i<ccc.length; i++)
			System.out.println (ccc[i]);
	}
	
	
	public static double[] inverterVetor(double[] abc)
	{
		double[] xyz = new double [abc.length];
		
		for (int i=0, j=xyz.length-1; i<abc.length; ++i, --j)
			xyz[j]=abc[i];
		
		return xyz;
	}
	
}