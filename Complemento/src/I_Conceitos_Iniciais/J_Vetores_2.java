package I_Conceitos_Iniciais;

public class J_Vetores_2
{	public static void main(String[] args)
	{	 int i;
		 
// 1° metodo
		 System.out.println("Primeiro exemplo:");
		 int[] a = new int[10];
		 for (i = 0; i < a.length; ++i)		//lenght (comprimento) -> Não precisa colocar os colchetes e a capacidade de armazenamento do vetor
			 System.out.println(a[i]);
		 
// 2° metodo
		 System.out.println("\n\nSegundo exemplo:");
		 int[] x = {1,2,3,4,5,6,7,8,9,10};
		 for (i = 0; i < x.length; ++i)
			 System.out.println(x[i]);
		 
// 3° metodo
		 System.out.println("\n\nTerceiro exemplo:");
		 int[] y= new int[10];
		 java.util.Arrays.fill(y, 20);			//Método que permite especificar um valor para o vetor
		 for (i = 0; i < y.length; ++i)
			 System.out.println(y[i]);
		 
// 4° metodo
		 System.out.println("\n\nQuarto exemplo:");
		 int[] z= new int[10];
		 java.util.Arrays.fill(z, 2, 5, 30);	//Os membors 2 a 5 do vetor recebem 30, mas o 5 não é inclusi (obs: começa com zero)
		 for (i = 0; i < z.length; ++i)
			 System.out.println(z[i]);
	}
}