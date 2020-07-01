package VI_Interface_GUI;

import javax.swing.JOptionPane;

public class B_Mensagem 
{	public static void main (String[] args)
	{
		String name = JOptionPane.showInputDialog ("What's your name?");
		
		String message = String.format ("Welcome, "+name+ ", to Java Programming!");
		
		JOptionPane.showMessageDialog (null, message);

	}
}