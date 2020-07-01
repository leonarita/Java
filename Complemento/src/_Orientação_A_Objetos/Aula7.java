package _Orienta��o_A_Objetos;

import javax.swing.JOptionPane;

public class Aula7 {

	public static int fat ( int n)
	{	if (n==0)
			return 1;
		else
			return (n*fat(n-1));
	}
	
	public static void main (String args[])
	{	int n;
		String E;
		
		try
		{	E = JOptionPane.showInputDialog("Forne�a um nro:");
			n = Integer.parseInt(E);
			
			if (n<0) throw new Exception ("Negativo");
			JOptionPane.showMessageDialog(null, "Fatorial de n = " + fat(n));
		}
		
		catch(NumberFormatException e)
		{	JOptionPane.showMessageDialog(null, "Erro: n�o foi digitado um n�mero inteiro!");		}
		
		catch(Exception Negativo)
		{	JOptionPane.showMessageDialog(null, "Erro: n�o existe fatorial de n�mero negativo!");	}
		
		System.exit(0);
	}
}
