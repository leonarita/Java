package aula01;

import javax.swing.JOptionPane;

public class Exercicio1 {

	public static void main (String[] args)
	{
		int n1 = Integer.parseInt(JOptionPane.showInputDialog("Informe a primeira nota: "));
		int n2 = Integer.parseInt(JOptionPane.showInputDialog("Informe a segunda nota: "));
		
		JOptionPane.showMessageDialog(null, "A m�dia do aluno � "+ ((n1+n2)/2));
	}
}
