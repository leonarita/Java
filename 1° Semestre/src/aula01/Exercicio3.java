package aula01;

import javax.swing.JOptionPane;

public class Exercicio3 {

	public static void main(String[] args) {

		float prec = Float.parseFloat(JOptionPane.showInputDialog("Informe o pre�o do combust�vel:"));
		float dist = Float.parseFloat(JOptionPane.showInputDialog("Informe a dist�ncia (Km): "));
		float consumo = Float.parseFloat(JOptionPane.showInputDialog("Informe o consumo (Km/L): "));
		
		//		REGRA DE 3
		// consumo Km --- L
		//   dist  Km --- litro L
		
		float litro = dist / consumo;
		
		JOptionPane.showMessageDialog(null, "O pre�o final ser� RS" + (litro*prec));
	}
}
