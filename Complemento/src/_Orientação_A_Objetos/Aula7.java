package _Orientação_A_Objetos;

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
		{	E = JOptionPane.showInputDialog("Forneça um nro:");
			n = Integer.parseInt(E);
			
			if (n<0) throw new Exception ("Negativo");
			JOptionPane.showMessageDialog(null, "Fatorial de n = " + fat(n));
		}
		
		catch(NumberFormatException e)
		{	JOptionPane.showMessageDialog(null, "Erro: não foi digitado um número inteiro!");		}
		
		catch(Exception Negativo)
		{	JOptionPane.showMessageDialog(null, "Erro: não existe fatorial de número negativo!");	}
		
		System.exit(0);
	}
}
